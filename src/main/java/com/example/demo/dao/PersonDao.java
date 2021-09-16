package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonDao")
public class PersonDao {

    private static ArrayList<Person> db = new ArrayList<>();

    public int addUser(Person person){
        this.db.add(new Person(UUID.randomUUID(),person.getName()));
        return 1;
    }

    public ArrayList<Person> getAllPerson(){
        return this.db;
    }

    public Optional<Person> getOnePerson(UUID id){
        Optional<Person> filteredPerson = this.db.stream().filter(person->person.getId().equals(id)).findFirst();
        return filteredPerson;
    }


    public int deletePerson(UUID id) {
        Optional<Person> persontoDelete=this.getOnePerson(id);
        if(persontoDelete.isEmpty()) {
            return 0;
        }
        else {
            this.db.remove(persontoDelete.get());
            return 1;
        }

    }

    public int updatePerson(UUID id,Person updateperson) {
        return this.getOnePerson(id).map(person->{
            int pindex = this.db.indexOf(person);
            this.db.set(pindex , new Person(id,updateperson.getName()));
            return 1;
        }).orElse(0);
    }
}
