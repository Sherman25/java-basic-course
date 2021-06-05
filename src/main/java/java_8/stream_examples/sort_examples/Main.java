package java_8.stream_examples.sort_examples;

import java_8.stream_examples.flat_map_example.Beer;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List.of(new Beer("T", 13), new Beer("K", 12))
                .stream()
                //.peek(System.out::println)
                .sorted()
                .forEach(System.out::println);

        List.of("Java", "Scala", "C#")
                .stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
               // .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}
