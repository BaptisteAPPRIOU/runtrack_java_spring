package com.example.Jour03.repository;

import com.example.Jour03.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();                         // Récupère toutes les entités Person
    void deleteById(Long id);                       // Supprime une entité par son ID
    boolean existsById(Long id);                    // Vérifie si une entité existe par son ID

    List<Person> findByLastName(String lastName);   // Trouve les personnes par leur nom de famille
}