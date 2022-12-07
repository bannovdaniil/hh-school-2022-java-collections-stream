package common;

public interface PersonConverter {
    ApiPersonDto convert(Person person);

    ApiPersonDto convert(Person person, Integer areaId);
}
