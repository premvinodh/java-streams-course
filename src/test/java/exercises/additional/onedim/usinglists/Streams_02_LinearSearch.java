package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
import org.junit.Test;

public class Streams_02_LinearSearch {

    private final List<Integer> lstNumbers = Arrays.asList(55, 22, 33, 11, 44);
    private final int searchElement = 11; // Found
//    private final int searchElement = 10; // Not Found

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        boolean flag = false;
        for (int i = 0; i < lstNumbers.size(); i++) {
            if (lstNumbers.get(i) == searchElement) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Search Element found");
        } else {
            System.out.println("Search Element not found");
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        Optional<Integer> optElem = lstNumbers.stream()
            .filter(value -> value == searchElement)
            .findFirst();

        if (optElem.isPresent()) {
            System.out.println("Search Element found");
        } else {
            System.out.println("Search Element not found");
        }
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println(
            "Declarative Approach IntStream - Method 1: Similar to imperative approach");

        AtomicBoolean found = new AtomicBoolean(false);
        IntStream.range(0, lstNumbers.size())
            .forEach(i -> {
                if (lstNumbers.get(i) == searchElement) {
                    found.set(true);
                }
            });

        if (found.get()) {
            System.out.println("Search Element found");
        } else {
            System.out.println("Search Element not found");
        }
    }

    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach IntStream - Method 2: Using mapToObj");

        Optional<Integer> optElement = IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .filter(value -> value == searchElement)
            .findFirst();

        if (optElement.isPresent()) {
            System.out.println("Search Element found");
        } else {
            System.out.println("Search Element not found");
        }
    }
}
