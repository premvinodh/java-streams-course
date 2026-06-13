package exercises.additional.twodim.usingarrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_02_SumOfElementsOf2DMatrix {

    private final int[][] arrNumbers = new int[][]{
        {55, 18, 86},
        {43, 29, 66}
    };
    private final int cols = arrNumbers[0].length;
    private final int rows = arrNumbers.length;

    @Test
    public void imperativeApproachUsingArrays() throws IOException {
        System.out.println("Imperative Approach - Arrays");

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum = sum + arrNumbers[i][j];
            }
        }
        System.out.println("Sum of elements of the 2D Array :" + sum);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger sum = new AtomicInteger(0);
        IntStream.range(0, rows)
            .forEach(i -> {
                IntStream.range(0, cols)
                    .forEach(j -> {
                        sum.set(sum.intValue() + arrNumbers[i][j]);
                    });
            });
        System.out.println("Sum of elements of the 2D Array :" + sum);
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        int sum = IntStream.range(0, rows)
            .mapToObj(i -> arrNumbers[i])
            .flatMapToInt(Arrays::stream)
            .sum();
        System.out.println("Sum of elements of the 2D Array : " + sum);
    }

    @Test
    public void declarativeApproachUsingStreamsOnArrays() throws Exception {
        System.out.println("Declarative Approach");

        int sum = Arrays.stream(arrNumbers)
            .flatMapToInt(Arrays::stream)
            .sum();
        System.out.println("Sum of elements of the 2D Array : " + sum);
    }
}
