package exercises.additional.twodim.usingarrays.numberpyramids;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * <pre>
 * 		5	6	7	8	9
 * 			4	5	6	7
 * 				3	4	5
 * 					2	3
 * 						1
 * </pre>
 */
public class Streams_07_NumberPyramid7 {

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
                            valueToPrint.getAndIncrement()); // Minimize this lambda expression
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
                    .mapToObj(k -> String.format("%4d", valueToPrint.getAndIncrement()))
                    .collect(Collectors.joining());

                return spaces + values1;
            }).forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreamsOnArrays() throws Exception {
        System.out.println("Declarative Approach");

    }
}
