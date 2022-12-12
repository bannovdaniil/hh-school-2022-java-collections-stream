package tasks;

import common.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task3 {

    public static List<Person> sort(Collection<Person> persons) {

        return persons.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Person::getSecondName, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Person::getFirstName, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Person::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }
}
