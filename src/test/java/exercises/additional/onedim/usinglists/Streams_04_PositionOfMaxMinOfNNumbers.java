package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_04_PositionOfMaxMinOfNNumbers {

    private final List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        int max = 0;                        int maxIndex = 0;
        int min = Integer.MAX_VALUE;        int minIndex = 0;

        for (int i = 0; i < lstNumbers.size(); i++) {
            if (lstNumbers.get(i) < min) {
                min = lstNumbers.get(i);
                minIndex = i;
            }
            if (lstNumbers.get(i) > max) {
                max = lstNumbers.get(i);
                maxIndex = i;
            }
        }
        System.out.println("Maximum :" + max + " found at index :" + (maxIndex + 1));
        System.out.println("Minimum :" + min + " found at index :" + (minIndex + 1));
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);   AtomicInteger maxIndex = new AtomicInteger();
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);   AtomicInteger minIndex = new AtomicInteger();

        IntStream.range(0, lstNumbers.size())
            .forEach(index -> {
                int value = lstNumbers.get(index);

                if (value < min.get()) {
                    min.set(value);
                    minIndex.set(index);
                }

                if (value > max.get()) {
                    max.set(value);
                    maxIndex.set(index);
                }
            });
        System.out.println("Maximum :" + max.get() + " found at index :" + (maxIndex.get() + 1));
        System.out.println("Minimum :" + min.get() + " found at index :" + (minIndex.get() + 1));
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicInteger max = new AtomicInteger(0);           AtomicInteger maxIndex = new AtomicInteger(0);
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);     AtomicInteger minIndex = new AtomicInteger(0);

        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                if (lstNumbers.get(i) < min.intValue()) {
                    min.set(lstNumbers.get(i));
                    minIndex.set(i);
                }
                if (lstNumbers.get(i) > max.intValue()) {
                    max.set(lstNumbers.get(i));
                    maxIndex.set(i);
                }
            });
        System.out.println("Maximum :" + max + " found at index :" + (maxIndex.intValue() + 1));
        System.out.println("Minimum :" + min + " found at index :" + (minIndex.intValue() + 1));
    }
}
