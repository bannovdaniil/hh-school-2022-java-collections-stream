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

        Map<Integer, Area> areaMap = areas.stream()
                .collect(Collectors.toMap(Area::getId, area -> area));

        return persons.stream()
                .flatMap(person -> personAreaIds.get(person.getId()).stream()
                        .filter(areaMap::containsKey)
                        .map(areaMap::get)
                        .map(area -> person.getFirstName() + " - " + area.getName()))
                .collect(Collectors.toSet());
    }
}
