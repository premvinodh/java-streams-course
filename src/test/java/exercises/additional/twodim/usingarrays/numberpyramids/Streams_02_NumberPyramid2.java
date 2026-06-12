package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 * 0
 * 1    0
 * 0    1   0
 * 1    0   1   0
 * 0    1   0   1   0
 * </pre>
 */
public class Streams_02_NumberPyramid2 {

    private final int noOfLines = 5;

    @Test
    public void imperativeApproach() throws IOException {
        System.out.println("Imperative Approach - Arrays");

        for (int i = 1; i <= noOfLines; i++) {
            int valueToPrint = (i + 1) % 2;
            for (int j = 0; j < i; j++) {
                System.out.printf("%4d", valueToPrint);
                if (valueToPrint == 0) {
                    valueToPrint = 1;
                } else {
                    valueToPrint = 0;
                }
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
                AtomicInteger valueToPrint = new AtomicInteger((i + 1) % 2);

                IntStream.range(0, i)
                    .forEach(j -> {
                        System.out.printf("%4d", valueToPrint.intValue());
                        if (valueToPrint.intValue() == 0) {
                            valueToPrint.set(1);
                        } else {
                            valueToPrint.set(0);
                        }
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.rangeClosed(1, noOfLines)
            .forEach(i -> {
                IntStream.range(0, i)
                    .mapToObj(j -> String.format("%4d", (i + 1 + j) % 2))
                    .forEach(System.out::print);

                System.out.println();
            });

        IntStream.rangeClosed(1, noOfLines)
            .mapToObj(i ->
                IntStream.range(0, i)
                    .mapToObj(j -> String.format("%4d", (i + 1 + j) % 2))
                    .collect(Collectors.joining())
            )
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        System.out.println("Declarative Approach - List");

    }
}
