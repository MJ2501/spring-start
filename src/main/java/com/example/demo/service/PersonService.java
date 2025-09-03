package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	public List<Person> getAllPersons(){
		return personRepo.findAll();
	}
	
	public Optional<Person> getPersonById(Long id){
		return personRepo.findById(id);
	}
	
	public Person savePerson(Person person) {
		return personRepo.save(person);
	}
	
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
	
	public Person updatePerson(Long id, Person personDetails) {
		Person person = personRepo.findById(id).orElseThrow();
		person.setName(personDetails.getName());
		person.setAge(personDetails.getAge());
		return personRepo.save(person);
	}
	
	public List<Person> getPersonByName(String name) {
		return personRepo.findByNameContainingIgnoreCase(name);
	}
	
}
