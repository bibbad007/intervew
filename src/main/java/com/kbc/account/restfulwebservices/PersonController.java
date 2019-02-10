package com.kbc.account.restfulwebservices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbc.account.dto.PersonDto;
import com.kbc.account.exceptions.PersonNotFoundException;
import com.kbc.account.services.PersonServices;

@RestController
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping("/persons")
	public List<PersonDto> retrieveAllPersons() {
		return service.findAll();
	}

	@GetMapping("/persons/{id}")
	public PersonDto retrievePerson(@PathVariable long id) {
	
		PersonDto person = service.findById(id);
		
		if(person==null)
			throw new PersonNotFoundException("id-"+ id);
		
		return person;
	}

	@DeleteMapping("/persons/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);			
	}


	@PostMapping("/persons")
	public ResponseEntity<Object> createPerson(@Valid @RequestBody PersonDto personDto) {		
		return service.save(personDto);	
		
	}
}

