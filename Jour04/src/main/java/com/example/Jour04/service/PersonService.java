package com.example.Jour04.service;

import com.example.Jour04.domain.Person;
import com.example.Jour04.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        if (personRepository.count() == 0) {
            personRepository.save(new Person("Alice", 25));
            personRepository.save(new Person("Bob", 30));
            personRepository.save(new Person("Charlie", 35));
        }
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    public Person updatePerson(Long id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}