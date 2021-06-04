package java_8.stream_examples.infinite_stream_example;

import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        DoubleStream.generate(System::nanoTime).forEach(System.out::println);
    }
}
