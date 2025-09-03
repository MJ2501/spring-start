package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.utilities.ApiResponse;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private MessageSource messageSource;
	
//	@GetMapping
//	public List<Person> getAllPersons() {
//		return personService.getAllPersons();
//	}
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPersons(){
		List<Person> person = personService.getAllPersons();
		if(person.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(person);
	}

//	@GetMapping("/{id}")
//	public Person getPersonById(@PathVariable Long id) {
//		return personService.getPersonById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//				messageSource.getMessage("user.not.found", new Object[] { id }, null)));
//	}

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

	@PostMapping("/name/{name}")
	public List<Person> getPersonByName(@PathVariable String name) {
		return personService.getPersonByName(name);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id)
				.map(person -> ResponseEntity.ok(new ApiResponse(messageSource.getMessage("user.found", null, null), person)))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse(messageSource.getMessage("user.not.found",new Object[] { id }, null), null)));
	}
}
