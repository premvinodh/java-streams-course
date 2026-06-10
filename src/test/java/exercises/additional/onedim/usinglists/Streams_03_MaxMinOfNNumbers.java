package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_03_MaxMinOfNNumbers {

    private final List<Integer> lstNumbers = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < lstNumbers.size(); i++) {
            if (lstNumbers.get(i) < min) {
                min = lstNumbers.get(i);
            }
            if (lstNumbers.get(i) > max) {
                max = lstNumbers.get(i);
            }
        }
        System.out.println("Maximum :" + max);
        System.out.println("Minimum :" + min);
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        Integer max = lstNumbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Maximum :" + max);

        Integer min = lstNumbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Minimum :" + min);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger max = new AtomicInteger(0);
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);

        IntStream.range(0, lstNumbers.size()).forEach(i -> {
            if (lstNumbers.get(i) < min.intValue()) {
                min.set(lstNumbers.get(i));
            }
            if (lstNumbers.get(i) > max.intValue()) {
                max.set(lstNumbers.get(i));
            }
        });

        System.out.println("Maximum :" + max.get());
        System.out.println("Minimum :" + min.get());
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        Integer minElm = IntStream.range(0, lstNumbers.size()).mapToObj(lstNumbers::get)
            .min(Comparator.naturalOrder()).get();

        Integer maxElm = IntStream.range(0, lstNumbers.size()).mapToObj(lstNumbers::get)
            .max(Comparator.naturalOrder()).get();

        System.out.println("Maximum :" + maxElm);
        System.out.println("Minimum :" + minElm);
    }
}
