package lectures;


import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

    final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

    /**
     * Find the any number which is greater than 5 and less than 10.
     *
     * @throws Exception
     */
    @Test
    public void findAny() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int any = Arrays.stream(numbers)
            .filter(numbersLessThan10)
            .findAny()
            .get();
        System.out.println(any);
    }

    /**
     * Find the first number which is greater than 5 and less than 10.
     *
     * @throws Exception
     */
    @Test
    public void findFirst() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int first = Arrays.stream(numbers)
            .filter(numbersLessThan10)
            .findFirst()
            .get();
        System.out.println(first);
    }
}