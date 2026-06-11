package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_17_CountPerfects {

    private final List<Integer> lstNumbers = Arrays.asList(55, 6, 86, 28, 496);

    /**
     * <pre>
     * A perfect number is a positive integer that is equal to the sum of its proper divisors
     * (excluding the number itself).
     *
     * For example, 6 is perfect because its divisors 1, 2, and 3 add up to 6 (1 + 2 + 3 = 6).
     * The first four perfect numbers are:
     *      6 (Divisors: 1, 2, 3 → 1+2+3 = 6)
     *      28 (Divisors: 1, 2, 4, 7, 14 → 1+2+4+7+14 = 28)
     *      496
     *      8128
     * </pre>
     *
     * @throws IOException
     */
    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int count = 0;
        for (int i = 0; i < lstNumbers.size(); i++) {
            if (isPerfect(lstNumbers.get(i))) {
                count++;
            }
        }
        System.out.println("No. of Perfects: " + count);
    }

    private boolean isPerfect(Integer num) {
        int sum = 0;
        for (int j = 1; j <= num / 2; j++) {
            if (num % j == 0) {
                if (num % j == 0) {
                    sum += j;
                }
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        long count = lstNumbers.stream()
            .filter(value -> isPerfect(value))
            .count();
        System.out.println("No. of Perfects: " + count);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger count = new AtomicInteger(0);
        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                if (isPerfect(lstNumbers.get(i))) {
                    count.incrementAndGet();
                }
            });
        System.out.println("No. of Perfects: " + count.intValue());
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        long count = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .filter(num -> isPerfect(num))
            .count();
        System.out.println("No. of Perfects: " + count);
    }
}
