package java_exam;

import java.util.Random;

public class TextGenerator {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'


    public String generateText(int targetStringLength) {
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}
