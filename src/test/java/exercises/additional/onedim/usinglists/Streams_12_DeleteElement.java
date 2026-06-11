package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Streams_12_DeleteElement {

    /**
     * Simple alternative to the below imperativeApproach lstNumbers.removeIf(n -> n ==
     * valueToDelete);
     *
     * @throws IOException
     */
    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        List<Integer> lstNumbers = new ArrayList<>(Arrays.asList(55, 32, 86, 43, 29));
        int valueToDelete = 43;

        for (int i = 0; i < lstNumbers.size(); i++) {
            if (lstNumbers.get(i) == valueToDelete) {
                lstNumbers.remove(i);
                break; // stop after removing first occurrence
            }
        }
        System.out.println(lstNumbers);
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        List<Integer> lstNumbers = Arrays.asList(55, 32, 86, 43, 29);
        Integer valueToDelete = 43;

        List<Integer> elementsAfterDel = lstNumbers.stream()
            .filter(n -> !n.equals(valueToDelete))
            .collect(Collectors.toList());
        System.out.println(elementsAfterDel);
    }
}
