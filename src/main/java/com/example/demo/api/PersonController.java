package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import com.example.demo.model.Person;
import com.example.demo.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody @Valid @NonNull Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping
    public int deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "/{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }

}
