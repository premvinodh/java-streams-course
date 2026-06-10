package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Sort the elements in descending order
 */
public class Streams_05_SortDescOfNNumbers {

    private final List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

    /**
     * Collections.sort(lstNumbers, Collections.reverseOrder()); // Simplest alternative
     *
     * @throws IOException
     */
    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        for (int i = 0; i < lstNumbers.size() - 1; i++) {
            for (int j = i + 1; j < lstNumbers.size(); j++) {
                if (lstNumbers.get(i) < lstNumbers.get(j)) {
                    int temp = lstNumbers.get(i);
                    lstNumbers.set(i, lstNumbers.get(j));
                    lstNumbers.set(j, temp);
                }
            }
        }
        System.out.println("Elements in sorted order - descending");
        for (Integer val : lstNumbers) {
            System.out.print(val + " ");
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        List<Integer> sortedDescending = lstNumbers.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        System.out.println("Elements in sorted order - descending");
        sortedDescending.stream().forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 1: Similar to imperative approach");

        IntStream.range(0, lstNumbers.size() - 1)
            .forEach(i ->
                IntStream.range(i + 1, lstNumbers.size())
                    .forEach(j -> {
                        if (lstNumbers.get(i) < lstNumbers.get(j)) {
                            int temp = lstNumbers.get(i);
                            lstNumbers.set(i, lstNumbers.get(j));
                            lstNumbers.set(j, temp);
                        }
                    })
            );

        System.out.println("Elements in sorted order - descending");
        lstNumbers.stream()
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        List<Integer> sortedNums = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get).sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        System.out.println("Elements in sorted order - descending");
        sortedNums.stream()
            .forEach(System.out::println);
    }
}
