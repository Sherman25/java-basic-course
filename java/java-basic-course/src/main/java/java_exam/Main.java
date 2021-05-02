package java_exam;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        final String serializableFilesPath = "src/main/java/java_exam/quotes/";
        final String deserializableFilesPath = "src/main/java/java_exam/json/";

        BlockingQueue<String> dataBase = new LinkedBlockingDeque<>();
        AtomicInteger id = new AtomicInteger(1);
        TextGenerator tg = new TextGenerator();
        Random random = new Random();

        Runnable producer = () -> {
            while(true) {
                int targetStringLength = random.nextInt(30);
                String text = tg.generateText(targetStringLength);
                Status status = Status.getTextStatus(targetStringLength);
                Quote quote = new Quote(id.getAndIncrement(), text, status);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date();
                String createDate = dateFormat.format(timestamp);
                String filePath = serializableFilesPath + createDate + ".ser";

                try {
                    Thread.sleep(1000);
                    FileOutputStream fileOut =
                            new FileOutputStream(filePath);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(quote);
                    out.close();
                    fileOut.close();
                    dataBase.add(filePath);
                } catch (IOException i) {
                    i.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable consumer = () -> {
            while(true) {
                try {
                    Thread.sleep(3000);
                    String filePath = dataBase.take();
                    FileInputStream fis = new FileInputStream(filePath);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Object o = ois.readObject();
                    ObjectMapper mapper = new ObjectMapper();
                    String jsonStr = mapper.writeValueAsString(o);
                    System.out.println(jsonStr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
