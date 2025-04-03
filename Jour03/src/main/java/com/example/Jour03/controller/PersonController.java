package com.example.Jour03.controller;

import com.example.Jour03.domain.Person;
import com.example.Jour03.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("/persons/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/persons/update/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute Person person) {
        person.setId(id);
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons";
    }
}
