package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Sort the elements in ascending order
 */
public class Streams_06_SortAscOfNNumbers {

    /**
     * Collections.sort(lstNumbers, Collections.naturalOrder()); // Simplest alternative
     *
     * @throws IOException
     */
    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

        for (int i = 0; i < lstNumbers.size() - 1; i++) {
            for (int j = i + 1; j < lstNumbers.size(); j++) {
                if (lstNumbers.get(i) > lstNumbers.get(j)) {
                    int temp = lstNumbers.get(i);
                    lstNumbers.set(i, lstNumbers.get(j));
                    lstNumbers.set(j, temp);
                }
            }
        }
        System.out.println("Elements in sorted order - ascending");
        for (Integer val : lstNumbers) {
            System.out.println(val);
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

        List<Integer> sortedDescending = lstNumbers.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());

        System.out.println("Elements in sorted order - ascending");
        sortedDescending.stream()
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

        IntStream.range(0, lstNumbers.size() - 1)
            .forEach(i ->
                IntStream.range(i + 1, lstNumbers.size())
                    .forEach(j -> {
                        if (lstNumbers.get(i) > lstNumbers.get(j)) {
                            int temp = lstNumbers.get(i);
                            lstNumbers.set(i, lstNumbers.get(j));
                            lstNumbers.set(j, temp);
                        }
                    })
            );

        System.out.println("Elements in sorted order - ascending");
        lstNumbers.stream()
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);

        List<Integer> sortedNums = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());

        System.out.println("Elements in sorted order - ascending");
        sortedNums.stream()
            .forEach(System.out::println);
    }
}
