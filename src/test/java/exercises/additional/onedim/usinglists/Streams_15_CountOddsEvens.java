package exercises.additional.onedim.usinglists;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Streams_15_CountOddsEvens {

    private final List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int evenCount = 0;
        int oddCount = 0;

        for (Integer number : lstNumbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Number of evens: " + evenCount);
        System.out.println("Number of odds: " + oddCount);
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        AtomicInteger evenCount = new AtomicInteger(0);
        AtomicInteger oddCount = new AtomicInteger(0);

        lstNumbers.stream()
            .forEach(number -> {
                if (number % 2 == 0) {
                    evenCount.getAndIncrement();
                } else {
                    oddCount.getAndIncrement();
                }
            });
        System.out.println("Number of evens: " + evenCount.intValue());
        System.out.println("Number of odds: " + oddCount.intValue());
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger evenCount = new AtomicInteger(0);
        AtomicInteger oddCount = new AtomicInteger(0);

        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                Integer number = lstNumbers.get(i);;
                if (number % 2 == 0) {
                    evenCount.getAndIncrement();
                } else {
                    oddCount.getAndIncrement();
                }
            });
        System.out.println("Number of evens: " + evenCount.intValue());
        System.out.println("Number of odds: " + oddCount.intValue());
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        long evenCount = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .filter(number -> number % 2 == 0)
            .count();

        long oddCount = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .filter(number -> number % 2 != 0)
            .count();

        System.out.println("Number of evens: " + evenCount);
        System.out.println("Number of odds: " + oddCount);
    }
}
