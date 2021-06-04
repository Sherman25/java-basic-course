package java_8.stream_examples.flat_map_example;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<BeerContainer> containerList = List.of(BeerContainer.builder()
                .beer(Beer.builder().name("tuborg").price(10).build())
                .beer(Beer.builder().name("leff").price(16).build()).build(),

                BeerContainer.builder().build(),

                BeerContainer.builder()
                        .beer(Beer.builder().name("Goldstar").price(10).build())
                        .beer(Beer.builder().name("tuborg").price(10).build())
                        .beer(Beer.builder().name("leff").price(16).build()).build(),

                BeerContainer.builder()
                        .beer(Beer.builder().name("Goldstar").price(10).build())
                        .beer(Beer.builder().name("tuborg").price(10).build())
                        .beer(Beer.builder().name("leff").price(16).build()).build());

        /*long count = containerList.stream()
                .flatMap(beerContainer -> beerContainer.getBeers().stream())
                .count();*/

        long sum = containerList.stream()
                .skip(0)
                .distinct()
                .peek(System.out::println)
                .flatMap(beerContainer -> beerContainer.getBeers().stream())
                .mapToInt(Beer::getPrice)
                .sum();

        System.out.println("sum = " + sum);
    }
}
