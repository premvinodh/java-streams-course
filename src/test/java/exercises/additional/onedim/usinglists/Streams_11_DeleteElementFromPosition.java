package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_11_DeleteElementFromPosition {

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        List<Integer> lstNumbers = new ArrayList<>(
            Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1));
        int position = 4; // zero-based index

        for (int i = 0; i < lstNumbers.size(); i++) {
            if (i == position) {
                lstNumbers.remove(position);
            }
        }
        System.out.println(lstNumbers);
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1);
        int position = 4; // zero-based index

        AtomicInteger index = new AtomicInteger();

        List<Integer> result = lstNumbers.stream()
            .filter(n -> index.getAndIncrement() != position)
            .collect(Collectors.toList());

        System.out.println(result);
    }

    @Test
    public void declarativeApproachUsingIntStreamsOnLists() throws Exception {
        System.out.println(
            "Functional Approach - IntStream - Method 1: Almost similar to imperative approach");
        List<Integer> lstNumbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1));
        int position = 4; // zero-based index

        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                if (i == position) {
                    lstNumbers.remove(position);
                }
            });
        System.out.println(lstNumbers);
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        List<Integer> lstNumbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1);
        int position = 4; // zero-based index

        List<Integer> result = IntStream.range(0, lstNumbers.size())
            .filter(i -> i != position)
            .mapToObj(lstNumbers::get)
            .collect(Collectors.toList());

        System.out.println(result);
    }
}
