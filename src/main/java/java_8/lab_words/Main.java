package java_8.lab_words;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("data/quotes.txt");
        List<String> lines = Files.lines(Paths.get("data/quotes.txt")).collect(Collectors.toList());

        long count = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("( |, )")))
                //.peek(System.out::println)
                .count();
        System.out.println("Words in text = " + count);

        Double average = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("( |, )")))
                .mapToInt(String::length)
                //.peek(System.out::println)
                .average().getAsDouble();

        System.out.println("Average length of word = " + average);
    }
}
