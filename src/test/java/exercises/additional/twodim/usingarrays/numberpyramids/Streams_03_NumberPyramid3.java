package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 *                       1
 *                   2   3
 *               3   4   5
 *           4   5   6   7
 *      5    6   7   8   9
 * </pre>
 */
public class Streams_03_NumberPyramid3 {

    private final int noOfLines = 5;

    @Test
    public void imperativeApproach() throws IOException {
        System.out.println("Imperative Approach");

        for (int i = 1; i <= noOfLines; i++) {
            for (int j = 0; j < (noOfLines - i); j++) {
                System.out.printf("%4s", "");
            }

            int valueToPrint = i;
            for (int k = 1; k <= i; k++) {
                System.out.printf("%4d", valueToPrint++);
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

                IntStream.rangeClosed(0, (noOfLines - i))
                    .forEach(j -> {
                        // Minimize this lambda expression onto a single line
                        System.out.printf("%4s", "");
                    });

                AtomicInteger valueToPrint = new AtomicInteger(i);
                IntStream.rangeClosed(1, i)
                    .forEach(k -> {
                        // Minimize this lambda expression onto a single line
                        System.out.printf("%4d", valueToPrint.getAndIncrement());
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.rangeClosed(1, noOfLines)
            .mapToObj(i -> {
                String spaces = IntStream.rangeClosed(0, noOfLines - i)
                    .mapToObj(j -> String.format("%4s", ""))
                    .collect(Collectors.joining());

                String numbers = IntStream.range(i, 2 * i)
                    .mapToObj(n -> String.format("%4d", n))
                    .collect(Collectors.joining());

                return spaces + numbers;
            })
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        System.out.println("Declarative Approach");

    }
}
