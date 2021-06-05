package java_8.stream_examples.collect_examples;

import java_8.stream_examples.flat_map_example.Beer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(1, 10000)
          //      .parallel()
                .forEach(list::add);
        System.out.println(list.size());*/

        //List<Integer> collect = IntStream.range(1, 20).mapToObj(value -> Integer.valueOf(value)).collect(Collectors.toList());
        //List<Integer> collect = IntStream.range(1, 20).boxed().collect(Collectors.toList());

        /*Map<String, Integer> beersMap = Stream.of(
                new Beer("Tub", 12),
                new Beer("Cal", 11),
                new Beer("Cal", 15))
                .collect(Collectors.toMap(Beer::getName, Beer::getPrice, Integer::sum));

        System.out.println("beersMap = " + beersMap);*/


        /*Map<Integer, Long> collect1 = Stream.of(
                new Beer("Tub", 12),
                new Beer("Cal", 11),
                new Beer("Corona", 11),
                new Beer("Lef", 15),
                new Beer("Wai", 15))
                //.collect(Collectors.groupingBy(Beer::getPrice));
                //.collect(Collectors.groupingBy(Beer::getPrice, Collectors.toSet()));
                .collect(Collectors.groupingBy(Beer::getPrice, Collectors.counting()));

        System.out.println("collect1 = " + collect1);*/


        /*Map<Integer, Optional<Beer>> collect = Stream.of(
                new Beer("Tub", 12),
                new Beer("Cal", 11),
                new Beer("Corona", 11),
                new Beer("Lef", 15),
                new Beer("Wai", 15))
                .collect(Collectors.groupingBy(Beer::getPrice, Collectors.minBy(Beer::compareTo)));*/
    }
}
