package exercises.additional.twodim.usingarrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_01_Arrays2DOutput {

    private final int[][] arrNumbers = new int[][]{
        {55, 18, 86},
        {43, 29, 66}
    };
    private final int cols = arrNumbers[0].length;
    private final int rows = arrNumbers.length;

    @Test
    public void imperativeApproachUsingArrays() throws IOException {
        System.out.println("Imperative Approach - Arrays");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arrNumbers[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        IntStream.range(0, rows)
            .forEach(i -> {
                IntStream.range(0, cols)
                    .forEach(j -> {
                        System.out.print(arrNumbers[i][j] + " ");
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.range(0, rows)
            .mapToObj(i ->
                IntStream.range(0, cols)
                    .mapToObj(j -> String.valueOf(arrNumbers[i][j]))
                    .collect(Collectors.joining(" "))
            )
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreamsOnArrays() throws Exception {
        System.out.println("Declarative Approach - List");

        Arrays.stream(arrNumbers)
            .forEach(row -> {
                Arrays.stream(row)
                    .forEach(value -> System.out.print(value + " "));
                System.out.println();
            });
    }
}
