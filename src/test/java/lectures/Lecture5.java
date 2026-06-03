package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture5 {

    /**
     * Filter all the cars whose price is less than 20,000.
     *
     * @throws Exception
     */
    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();

        final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

        List<Car> carsFiltered = cars.stream()
                .filter(carPredicate)
                .collect(Collectors.toList());

        carsFiltered.forEach(System.out::println);
        System.out.println(carsFiltered.size());
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople() ;

        List<PersonDTO> dtos = people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

        assertThat(dtos).hasSize(1000);
        System.out.println(dtos.size());
    }

    /**
     * Complete method bellow: calculate the average car price.
     * Hint: Use .mapToDouble(...)  after getting all car prices then use .average()  to calculate the average price.
     *
     * @throws Exception
     */
    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        double average = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice) // .mapToDouble(car -> car.getPrice())
                .average()
                .orElse(0);

        System.out.println(average);
    }

    @Test
    public void test() throws Exception {
        MockData.getCars().forEach(System.out::println);
    }
}
