package tasks;

import common.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task3 {

    public static List<Person> sort(Collection<Person> persons) {

        return persons.stream()
                .sorted(Comparator.comparing(Person::getSecondName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getCreatedAt))
                .toList();
    }
}
