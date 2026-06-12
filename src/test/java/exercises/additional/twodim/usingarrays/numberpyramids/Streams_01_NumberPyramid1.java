package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 * 1
 * 2    3
 * 3    4   5
 * 4    5   6   7
 * 5    6   7   8   9
 * </pre>
 */
public class Streams_01_NumberPyramid1 {

    private final int noOfLines = 5;

    @Test
    public void imperativeApproach() throws IOException {
        System.out.println("Imperative Approach - Arrays");

        for (int i = 1; i <= noOfLines; i++) {
            int valueToPrint = i;
            for (int j = 0; j < i; j++) {
                System.out.printf("%4d", valueToPrint);
                valueToPrint++;
            }
            System.out.println("");
        }
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        IntStream.rangeClosed(1, noOfLines)
            .forEach(i -> {
                AtomicInteger valueToPrint = new AtomicInteger(i);
                IntStream.range(0, i)
                    .forEach(j -> {
                        System.out.printf("%4d", valueToPrint.intValue());
                        valueToPrint.incrementAndGet();
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.rangeClosed(1, noOfLines)
            .forEach(i -> {
                IntStream.range(i, i + i)
                    .mapToObj(v -> String.format("%4d", v))
                    .forEach(System.out::print);

                System.out.println("");
            });

        //
        IntStream.rangeClosed(1, noOfLines)
            .mapToObj(i ->
                IntStream.range(i, i + i)
                    .mapToObj(v -> String.format("%4d", v))
                    .collect(Collectors.joining())
            )
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreamsOnArrays() throws Exception {
        System.out.println("Declarative Approach - List");

    }
}
