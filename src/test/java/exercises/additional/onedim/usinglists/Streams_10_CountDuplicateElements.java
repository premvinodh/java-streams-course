package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_10_CountDuplicateElements {

    private final List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        List<Integer> lstNumbers = new ArrayList<>(numbers);

        for (int i = 0; i < lstNumbers.size() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < lstNumbers.size(); j++) {
                if (lstNumbers.get(i) == lstNumbers.get(j)) {
                    count = count + 1;
                    lstNumbers.remove(j);
                    j--; // adjust index after removal
                }
            }
            if (count > 0) {
                System.out.println(
                    "Element " + lstNumbers.get(i) + " occured " + (count + 1) + " times");
            }
        }
        System.out.println("\nElements of the array after removing duplicates...");
        for (int i = 0; i < lstNumbers.size(); i++) {
            System.out.println(lstNumbers.get(i));
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        System.out.println("Declarative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1);

        Map<Integer, Long> counts = lstNumbers.stream()
            .collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
            );

        counts.forEach((number, count) ->
            System.out.println(number + " -> " + count));

    }


}
