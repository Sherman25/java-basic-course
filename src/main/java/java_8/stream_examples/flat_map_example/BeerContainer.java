package java_8.stream_examples.flat_map_example;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerContainer {
    @Singular
    private List<Beer> beers;
}
