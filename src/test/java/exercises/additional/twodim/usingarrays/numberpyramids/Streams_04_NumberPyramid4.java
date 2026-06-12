package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 *                  1
 *              0   1
 *          1   0   1
 *      0   1   0   1
 * 1    0   1   0   1
 * </pre>
 */
public class Streams_04_NumberPyramid4 {

    private final int noOfLines = 5;

    @Test
    public void imperativeApproach() throws IOException {
        System.out.println("Imperative Approach");

        for (int i = 1; i <= noOfLines; i++) {
            for (int j = 1; j <= (noOfLines - i); j++) {
                System.out.printf("%4s", "");
            }

            int valueToPrint = i;
            for (int k = 1; k <= i; k++) {
                System.out.printf("%4d", valueToPrint % 2);
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
                IntStream.rangeClosed(1, (noOfLines - i))
                    .forEach(j -> {
                        // Minimize this lambda expression onto a single line
                        System.out.printf("%4s", "");
                    });

                AtomicInteger valueToPrint = new AtomicInteger(i);
                IntStream.rangeClosed(1, i)
                    .forEach(k -> {
                        // Minimize this lambda expression onto a single line
                        System.out.printf("%4d", valueToPrint.intValue() % 2);
                        valueToPrint.incrementAndGet();
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.rangeClosed(1, noOfLines)
            .mapToObj(i -> {
                String spaces = IntStream.rangeClosed(1, (noOfLines - i))
                    .mapToObj(j -> String.format("%4s", ""))
                    .collect(Collectors.joining());

                AtomicInteger valueToPrint = new AtomicInteger(i);
                String values = IntStream.rangeClosed(1, i)
                    .mapToObj(k -> String.format("%4d", valueToPrint.getAndIncrement() % 2))
                    .collect(Collectors.joining());

                return spaces + values;
            }).forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        System.out.println("Declarative Approach");

    }
}
