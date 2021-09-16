package com.example.demo.controllerapi;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.services.PersonService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
@RequestMapping("person")
@RestController
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping("add")
	public int addUser(@RequestBody Person person){
		return personService.addUser(person);
	}
	
	@GetMapping("get/all")
	public ArrayList<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
	@GetMapping("get/one/{id}")
	public Optional<Person> getOnePerson(@PathVariable("id") UUID id){
		return personService.getOnePerson(id);
	}
	@DeleteMapping("delete/one/{id}")
	public int deletePerson(@PathVariable("id") UUID id) {
		return personService.deletePerson(id);
	}
	@PutMapping("update/one/{id}")
	public int updatePerson(@PathVariable("id") UUID id,@RequestBody   Person updateperson) {
		return personService.updatePerson(id, updateperson);
	}

}
