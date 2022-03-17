package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/Person")
public class PersonController {

	
	private PersonService service;
	
	
	@Autowired 
	public PersonController(PersonService service) {
	this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		return new ResponseEntity<Person>(this.service.create(person), HttpStatus.CREATED);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Person>> readAllPersons(){
		return new ResponseEntity<List<Person>>(this.service.readAll(), HttpStatus.OK);
	}
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<Person> readById(@PathVariable long id){
		return new ResponseEntity<Person>(this.service.readById(id), HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person){
		return new ResponseEntity<Person>(this.service.update(id, person), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deletePerson(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}
