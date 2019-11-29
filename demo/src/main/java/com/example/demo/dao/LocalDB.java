package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("localDB")
public class LocalDB implements PersonDao {
    List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        System.out.println("LocalDB"+"\t"+id+"\t"+person.toString());
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        System.out.println(id);
        return DB.stream().filter(entry -> entry.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Person person = getPerson(id).orElse(null);
        if(person == null) return 0;
        DB.remove(person);
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person update) {
        Person person = getPerson(id).orElse(null);
        if(person == null) return 0;
        int index = DB.indexOf(person);
        DB.set(index, new Person(id, update.getName()));
        return 1;
    }
}
