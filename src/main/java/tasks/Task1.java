package tasks;

import common.Person;
import common.PersonService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task1 {

    private final PersonService personService;

    public Task1(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> findOrderedPersons(List<Integer> personIds) {
        Set<Person> persons = personService.findPersons(personIds);

        Map<Integer, Person> personMap = persons.stream()
                .collect(Collectors.toMap(Person::getId, person -> person));

        return personIds.stream()
                .filter(personMap::containsKey)
                .map(personMap::get)
                .toList();
    }
}
