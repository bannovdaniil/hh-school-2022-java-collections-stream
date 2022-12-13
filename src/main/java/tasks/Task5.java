package tasks;

import common.ApiPersonDto;
import common.Person;
import common.PersonConverter;

import java.util.List;
import java.util.Map;

public class Task5 {

    private final PersonConverter personConverter;

    public Task5(PersonConverter personConverter) {
        this.personConverter = personConverter;
    }

    public List<ApiPersonDto> convert(List<Person> persons, Map<Integer, Integer> personAreaIds) {
        return persons.stream()
                .map(person -> personConverter.convert(person, personAreaIds.get(person.getId())))
                .toList();
    }
}
