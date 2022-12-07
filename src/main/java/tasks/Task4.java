package tasks;

import common.ApiPersonDto;
import common.Person;
import common.PersonConverter;

import java.util.List;

public class Task4 {

    private final PersonConverter personConverter;

    public Task4(PersonConverter personConverter) {
        this.personConverter = personConverter;
    }

    public List<ApiPersonDto> convert(List<Person> persons) {

        return persons.stream()
                .map(personConverter::convert)
                .toList();
    }
}
