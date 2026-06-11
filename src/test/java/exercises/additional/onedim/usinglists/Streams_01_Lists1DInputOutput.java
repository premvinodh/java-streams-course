package exercises.additional.onedim.usinglists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;


public class Streams_01_Lists1DInputOutput {

    private final List<Integer> lstNumbers = Arrays.asList(55, 22, 33, 11, 44);

    @Test
    public void imperativeApproachUsingLists() throws IOException {
        System.out.println("Imperative Approach - List");

        for (int i = 0; i < lstNumbers.size(); i++) {
            System.out.println(lstNumbers.get(i));
        }
    }

    @Test
    public void declarativeApproachUsingStreamsOnLists() throws Exception {
        System.out.println("Declarative Approach - List");

        lstNumbers.stream()
            .forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingIntStreamsSimilarToImperativeApproach() throws Exception {
        System.out.println("IntStream - Method 1: Almost similar to imperative approach");

        // forEach on the IntStream --> gives the index
        IntStream.range(0, lstNumbers.size())
            .forEach(index -> {
                System.out.println(lstNumbers.get(index));
            });
    }


    @Test
    public void declarativeApproachUsingIntStreamsUsingMapToObj() throws Exception {
        System.out.println("Declarative Approach - List :: Using mapToObj");
        IntStream.range(0, lstNumbers.size())
            .mapToObj(lstNumbers::get)
            .forEach(System.out::println);
    }
}
