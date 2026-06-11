package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_14_ListSum {

    private final List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int sum = 0;
        for (int i = 0; i < lstNumbers.size(); i++) {
            sum = sum + lstNumbers.get(i);
        }
        System.out.println("Sum of all the elements of the list :: " + sum);
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        int sum = lstNumbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("Sum of all the elements of the list :: " + sum);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger sum = new AtomicInteger(0);
        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                sum.addAndGet(lstNumbers.get(i));
            });
        System.out.println("Sum of all the elements of the list :: " + sum.intValue());
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        System.out.println("*******First Method*******");
        AtomicInteger sum = new AtomicInteger(0);
        IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .forEach(sum::addAndGet);

        System.out.println("Sum of all the elements of the list :: " + sum.intValue());

        System.out.println("*******Second Method*******");
        int sum1 = IntStream.range(0, lstNumbers.size())
            .map(i -> lstNumbers.get(i))
            .sum();

        System.out.println("Sum of all the elements of the list :: " + sum1);
    }
}
