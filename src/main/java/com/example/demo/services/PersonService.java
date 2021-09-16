package com.example.demo.services;


import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(@Qualifier("PersonDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addUser(Person person){
        return  personDao.addUser(person);
    }

    public ArrayList<Person> getAllPerson(){
        return personDao.getAllPerson();
    }

    public Optional<Person> getOnePerson(UUID id){
        return personDao.getOnePerson(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id,Person updateperson) {
        return personDao.updatePerson(id, updateperson);
    }
}
