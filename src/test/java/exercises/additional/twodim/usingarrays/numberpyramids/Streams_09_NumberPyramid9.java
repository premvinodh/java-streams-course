package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 * 		1	0	1	0	1	0	1	0	1
 * 			0	1	0	1	0	1	0
 * 				1	0	1	0	1
 * 					0	1	0
 * 						1
 * </pre>
 */
public class Streams_09_NumberPyramid9 {

    private final int noOfLines = 5;

    @Test
    public void imperativeApproach() throws IOException {
        System.out.println("Imperative Approach");

        for (int i = noOfLines; i > -1; i--) {
            for (int j = 1; j <= (noOfLines - i); j++) {
                System.out.printf("%4s", "");
            }

            int valueToPrint = i;
            for (int k = 1; k <= i; k++) {
                System.out.printf("%4d", valueToPrint++ % 2);
            }

            valueToPrint--;
            for (int l = 1; l <= (i - 1); l++) {
                System.out.printf("%4d", --valueToPrint % 2);
            }
            System.out.println("");
        }
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        IntStream.rangeClosed(1, noOfLines)
            .map(i -> noOfLines + 1 - i)
            .forEach(i -> {
                IntStream.rangeClosed(1, (noOfLines - i))
                    .forEach(j -> {
                        System.out.printf("%4s", ""); // Minimize this lambda expression
                    });

                AtomicInteger valueToPrint = new AtomicInteger(i);
                IntStream.rangeClosed(1, i)
                    .forEach(k -> {
                        System.out.printf("%4d",
                            valueToPrint.getAndIncrement() % 2); // Minimize this lambda expression
                    });

                valueToPrint.decrementAndGet();
                IntStream.rangeClosed(1, (i - 1))
                    .forEach(l -> {
                        System.out.printf("%4d",
                            valueToPrint.decrementAndGet() % 2); // Minimize this lambda expression
                    });
                System.out.println("");
            });
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        IntStream.rangeClosed(1, noOfLines)
            .map(i -> noOfLines + 1 - i)
            .mapToObj(i -> {
                String spaces = IntStream.rangeClosed(1, (noOfLines - i))
                    .mapToObj(j -> String.format("%4s", ""))
                    .collect(Collectors.joining());

                AtomicInteger valueToPrint = new AtomicInteger(i);
                String values1 = IntStream.rangeClosed(1, i)
                    .mapToObj(k -> String.format("%4d", valueToPrint.getAndIncrement() % 2))
                    .collect(Collectors.joining());

                valueToPrint.decrementAndGet();
                String values2 = IntStream.rangeClosed(1, (i - 1))
                    .mapToObj(l -> String.format("%4d", valueToPrint.decrementAndGet() % 2))
                    .collect(Collectors.joining());

                return spaces + values1 + values2;
            }).forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreamsOnArrays() throws Exception {
        System.out.println("Declarative Approach");

    }
}
