package org.example.dao;

import org.example.model.Person;
import java.util.List;

public interface IPersonDao {
    public Person addPerson(Person person);
    List<Person> getAllPerson();
    void updatePerson(Person person);
    void deletePerson(int id);

}
