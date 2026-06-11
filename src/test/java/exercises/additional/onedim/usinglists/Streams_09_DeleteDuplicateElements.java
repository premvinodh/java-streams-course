package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Streams_09_DeleteDuplicateElements {

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        List<Integer> lstNumbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1));

        for (int i = 0; i < lstNumbers.size(); i++) {
            Integer current = lstNumbers.get(i);

            for (int j = i + 1; j < lstNumbers.size(); j++) {
                if (current.equals(lstNumbers.get(j))) {
                    lstNumbers.remove(j);
                    j--; // adjust index after removal
                }
            }
        }
        for (int i = 0; i < lstNumbers.size(); i++) {
            System.out.println(lstNumbers.get(i));
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 2, 6, 1);

        List<Integer> distinctElms = lstNumbers.stream()
            .distinct()
            .collect(Collectors.toList());

        distinctElms.stream()
            .forEach(System.out::println);
    }
}
