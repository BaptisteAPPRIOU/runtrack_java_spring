package com.example.Jour03.controller;

import com.example.Jour03.domain.Person;
import com.example.Jour03.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public String listPersons(Model model) {
        // Création d'exemples si la base est vide
        if (personRepository.count() == 0) {
            personRepository.save(new Person("Alice", 25));
            personRepository.save(new Person("Bob", 30));
            personRepository.save(new Person("Charlie", 35));
        }
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }
}
