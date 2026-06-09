package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture11 {

    /**
     * Concatenate names into one String joined by comma, You may have to remove the last comma.
     *
     * @throws Exception
     */
    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String join = "";
        for (String name : names) {
            join += name + ", ";
        }
        System.out.println(
            join.substring(0, join.length() - 2)); //Output:- anna, john, marcos, helena, yasmin
    }

    /**
     * Concatenate names into one String joined by comma, You may have to remove the last comma.
     *
     * @throws Exception
     */
    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String join = names.stream()
            .collect(Collectors.joining());
        System.out.println(join); // Output:- annajohnmarcoshelenayasmin

        String joinWithComma = names.stream()
            .collect(Collectors.joining(","));
        System.out.println(joinWithComma); // Output:- anna,john,marcos,helena,yasmin

        String convertToUpperJoinWithPipe = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining("|"));
        System.out.println(convertToUpperJoinWithPipe); // Output:- ANNA|JOHN|MARCOS|HELENA|YASMIN
    }
}
