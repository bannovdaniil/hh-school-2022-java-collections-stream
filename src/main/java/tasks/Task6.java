package tasks;

import common.Area;
import common.Person;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task6 {

    public static Set<String> getPersonDescriptions(Collection<Person> persons,
                                                    Map<Integer, Set<Integer>> personAreaIds,
                                                    Collection<Area> areas) {

        return persons.stream()
                .flatMap(person -> personAreaIds.get(person.getId()).stream()
                        .flatMap(areaId -> areas.stream()
                                .filter(area -> areaId.equals(area.getId()))
                                .map(areaById -> person.getFirstName() + " - " + areaById.getName())
                        )
                )
                .collect(Collectors.toSet());
    }
}
