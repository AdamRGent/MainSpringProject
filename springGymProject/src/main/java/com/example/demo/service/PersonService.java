package com.example.demo.service;

import java.util.List; 
import java.util.Optional;

import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;


import org.springframework.stereotype.Service;

@Service

public class PersonService implements ServiceMethods <Person>{

	private PersonRepo repo;
	
	
	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}
	
	
	@Override
	public Person create(Person person) {
		return this.repo.save(person);
	}

	@Override
	public List<Person> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Person readById(long id) {
		Optional<Person> getPerson = this.repo.findById(id);
		if(getPerson.isPresent()) {
			return getPerson.get();
		}
		return null;
	}

	@Override
	public Person update(long id, Person person) {
		Optional<Person> existingPerson = this.repo.findById(id);
		if(existingPerson.isPresent()) {
			Person exists = existingPerson.get();
			
			exists.setName(person.getName());
			exists.setBenchPressKG(person.getBenchPressKG());
			exists.setShoulderPressKG(person.getShoulderPressKG());
			exists.setBicepCurlKG(person.getBicepCurlKG());
			exists.setSquatKG(person.getSquatKG());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}
	
	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	
}
