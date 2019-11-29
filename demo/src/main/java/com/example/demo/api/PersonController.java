package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    int addPerson(@Valid @NotNull @RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @GetMapping(path="{id}")
    public Person getPerson(@PathVariable("id") UUID id){
        return personService.getPerson(id)
                .orElse(null);
    }
    @DeleteMapping(path="{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }
    @PutMapping(path="{id}")
    public int updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person){
        return personService.updatePerson(id, person);
    }
}
