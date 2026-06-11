package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_16_CountPrimes {

    private final List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int count = 0;
        for (int i = 0; i < lstNumbers.size(); i++) {
            if (isPrime(lstNumbers.get(i))) {
                count++;
            }
        }
        System.out.println("No. of Primes: " + count);
    }

    private boolean isPrime(Integer num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        long count = lstNumbers.stream()
            .filter(value -> isPrime(value))
            .count();
        System.out.println("No. of Primes: " + count);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger count = new AtomicInteger(0);
        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                if (isPrime(lstNumbers.get(i))) {
                    count.incrementAndGet();
                }
            });
        System.out.println("No. of Primes: " + count.intValue());
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        long count1 = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .filter(this::isPrime)
            .count();

        System.out.println("No. of Primes: " + count1);
    }
}
