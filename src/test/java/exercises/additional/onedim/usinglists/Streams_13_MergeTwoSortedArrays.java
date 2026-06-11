package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_13_MergeTwoSortedArrays {

    private final List<Integer> lstNumbers1 = Arrays.asList(11, 22, 35, 41, 60);
    private final List<Integer> lstNumbers2 = Arrays.asList(8, 12, 46, 94, 160);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        List<Integer> lstMerged = new ArrayList<>();
        int i = 0;                     int m = lstNumbers1.size();
        int j = 0;                     int n = lstNumbers2.size();

        while (i < m && j < n) {
            if (lstNumbers1.get(i) < lstNumbers2.get(j)) {
                lstMerged.add(lstNumbers1.get(i));
                i++;
            } else {
                lstMerged.add(lstNumbers2.get(j));
                j++;
            }
        }

        /* Transfer remaining elements of lstNumbers1 if any...*/
        for (int x = i; x < m; x++) {
            lstMerged.add(lstNumbers1.get(x));
        }

        /* Transfer remaining elements of lstNumbers2 if any...*/
        for (int x = j; x < n; x++) {
            lstMerged.add(lstNumbers2.get(x));
        }

        /* Display elements of lstMerged... */
        System.out.println("Merged elements...");
        for (i = 0; i < (m + n); i++) {
            System.out.println(lstMerged.get(i));
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        List<Integer> lstMerged = new ArrayList<>();
        AtomicInteger i = new AtomicInteger(0);     AtomicInteger m = new AtomicInteger(lstNumbers1.size());
        AtomicInteger j = new AtomicInteger(0);     AtomicInteger n = new AtomicInteger(lstNumbers2.size());

        IntStream.range(0, m.intValue() + n.intValue())
            .forEach(k -> {
                if (i.intValue() < m.intValue() && j.intValue() < n.intValue()) {
                    if (lstNumbers1.get(i.intValue()) < lstNumbers2.get(j.intValue())) {
                        lstMerged.add(lstNumbers1.get(i.intValue()));
                        i.incrementAndGet();
                    } else {
                        lstMerged.add(lstNumbers2.get(j.intValue()));
                        j.incrementAndGet();
                    }
                }
            });

        /* Transfer remaining elements of a if any...*/
        IntStream.range(i.intValue(), m.intValue())
            .forEach(x -> {
                lstMerged.add(lstNumbers1.get(x));
            });

        /* Transfer remaining elements of b if any...*/
        IntStream.range(j.intValue(), n.intValue())
            .forEach(x -> {
                lstMerged.add(lstNumbers2.get(x));
            });

        /* Display elements of c... */
        System.out.println("Merged elements...");
        lstMerged.stream()
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

    }
}
