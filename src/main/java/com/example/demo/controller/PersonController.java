package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id).orElseThrow();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
		return personService.updatePerson(id, person);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Person> getPersonByName(@PathVariable String name){
		return personService.getPersonByName(name);
	}
		
}
