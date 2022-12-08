package tasks;

import common.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8Test {
    private static Person person1, person2, person3, person4;
    private static Task8 task8;

    @BeforeAll
    public static void before() {
        task8 = new Task8();
        Instant time = Instant.now();
        person1 = new Person(1, "Fake person", time);
        person2 = new Person(2, "Ivan", "Ivanov", time.plusSeconds(1));
        person3 = new Person(3, "Ivan", "Ivanov", "Ivanovich", time.minusSeconds(1));
        person4 = new Person(4, "Person 3", time.plusSeconds(2));

    }

    private static Stream<Arguments> generateDataForGetNames() {
        return Stream.of(
                Arguments.of(null, List.of()),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(person1), List.of()),
                Arguments.of(List.of(person1, person2), List.of(person2.getFirstName())),
                Arguments.of(List.of(person1, person2, person3),
                        List.of(person2.getFirstName(), person3.getFirstName())),
                Arguments.of(List.of(person1, person2, person3, person4),
                        List.of(person2.getFirstName(), person3.getFirstName(), person4.getFirstName()))
        );
    }

    private static Stream<Arguments> generateDateForGetFullNameOfPerson() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(person1, "Fake person"),
                Arguments.of(person2, "Ivan Ivanov"),
                Arguments.of(person3, "Ivan Ivanovich Ivanov")
        );
    }

    private static Stream<Arguments> generateDataForUniqueNames() {
        return Stream.of(
                Arguments.of(null, List.of()),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(person1), List.of()),
                Arguments.of(List.of(person1, person2), List.of(person2.getFirstName())),
                Arguments.of(List.of(person1, person2, person3),
                        List.of(person2.getFirstName(), person3.getFirstName())),
                Arguments.of(List.of(person1, person2, person3, person4),
                        List.of(person2.getFirstName(), person3.getFirstName(), person4.getFirstName()))
        );
    }

    private static Stream<Arguments> generateDateForCountEvenElements() {
        return Stream.of(
                Arguments.of(Stream.of(1, 3, 5, 7), 0),
                Arguments.of(Stream.of(1, 2, 5, 7), 1),
                Arguments.of(Stream.of(), 0),
                Arguments.of(Stream.of(0), 1),
                Arguments.of(Stream.of(-1, -2, -4, 4, 7), 3),
                Arguments.of(Stream.of(2, 4, 6, 8), 4)
        );
    }

    private static Stream<Arguments> generateDateForHasSomePersonInTwoCollection() {
        return Stream.of(
                Arguments.of(List.of(person1), List.of(), false),
                Arguments.of(List.of(person1, person2), List.of(person2, person3, person4), true),
                Arguments.of(List.of(person1, person3), List.of(person2, person4), false),
                Arguments.of(List.of(person1, person3, person4), List.of(person2, person3), true)
        );
    }

    private static Stream<Arguments> generateDateForGetMapIdWithPersonNames() {
        return Stream.of(
                Arguments.of(null, Map.of()),
                Arguments.of(List.of(person1), Map.of(1, "Fake person")),
                Arguments.of(List.of(person2, person3), Map.of(2, "Ivan Ivanov", 3, "Ivan Ivanovich Ivanov"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataForGetNames")
    void getNames(List<Person> persons, List<String> expected) {
        var result = task8.getRealNames(persons);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateDataForUniqueNames")
    void getUniqueNames(List<Person> persons, List<String> expectedList) {
        var result = task8.getUniqueNames(persons);
        Set<String> expected = new HashSet<>(expectedList);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateDateForGetFullNameOfPerson")
    void getUniqueNames(Person person, String expected) {
        var result = task8.getFullNameOfPerson(person);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateDateForHasSomePersonInTwoCollection")
    void hasSomePersonInTwoCollection(List<Person> person1, List<Person> person2, boolean expected) {
        var result = task8.hasSomePersonInTwoCollection(person1, person2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateDateForCountEvenElements")
    void countEvenElements(Stream<Integer> numbers, long expected) {
        var result = task8.countEvenElements(numbers);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateDateForGetMapIdWithPersonNames")
    void getMapIdWithPersonNames(List<Person> persons, Map<Integer, String> expected) {
        var result = task8.getMapIdWithPersonNames(persons);
        assertEquals(expected, result);
    }
}