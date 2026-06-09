package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {

    /**
     * Select line 22 or 23 or 24 & (Show Intention Actions via Alt + Enter)
     *
     * @throws Exception
     */
    @Test
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(                                               // collect takes 3 parameters -> supplier, accumulator, combiner
                () -> new ArrayList<String>(),                      // ArrayList::new,   --> this is the supplier
                (list, element) -> list.add(element),               // ArrayList::add,   --> this is the accumulartor
                (list1, list2) -> list1.addAll(list2));             // ArrayList::addAll --> this is the combiner (used with multiple threads)
//        .collect(Collectors.toList());

        emails.forEach(System.out::println);
    }
}
