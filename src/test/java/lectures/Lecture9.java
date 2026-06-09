package lectures;


import java.util.Arrays;
import org.junit.Test;

public class Lecture9 {

    /**
     * Sum all the elements in the array using reduce
     *
     * @throws Exception
     */
    @Test
    public void reduce() throws Exception {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers)
            .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = Arrays.stream(integers)
            .reduce(0, Integer::sum);
        System.out.println(sum2);
    }
}

