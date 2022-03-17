package com.example.demo.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.PersonController;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@SpringBootTest
public class PersonControllerUnitTest {

	@Autowired
	private PersonController controller;
	
	@MockBean
	private PersonService service;
	
	@Test
	public void createPersonTest() {
		
		Person person = new Person("Russ", 80, 30, 40, 50);
		Mockito.when(this.service.create(person)).thenReturn(person);
		ResponseEntity<Person> response = new ResponseEntity<Person>(person, 
				HttpStatus.CREATED);
		assertThat(response).isEqualTo(this.controller.createPerson(person));
		Mockito.verify(this.service, times(1)).create(person);
	}
	
	@Test
	public void readAllTest () {
		
		Long id = 1L;
		Person Person = new Person ("Russ", 80, 30, 40, 50);
		Person.setId(id);
        List<Person> Persons = List.of(Person);
		Mockito.when(this.service.readAll()).thenReturn(Persons);
		ResponseEntity<List<Person>> response = new ResponseEntity<List<Person>>
		(Persons, HttpStatus.OK);
		assertThat(response).isEqualTo(this.controller.readAllPersons());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}
	
	  @Test
	 public void testReadById() {

	        Long id = 1L;
	        Person expected = new Person(id, "Russ", 80, 30, 40, 50);
	        Mockito.when(this.service.readById(id)).thenReturn(expected);
	        ResponseEntity<Person> response = new ResponseEntity<Person>(expected,
					HttpStatus.OK);
			assertThat(response).isEqualTo(this.controller.readById(1L));
	        Mockito.verify(this.service, Mockito.times(1)).readById(id);
	    }

	  @Test
	  public void testUpdate() {

	        Long id = 1L;
	        Person newValues = new Person("Russ", 80, 30, 40, 50);
	        Person existingPerson = new Person(id, "Russ", 80, 40, 40, 50);
	        Person updated = new Person(id, "Russ", 80, 30, 40, 50);
	        Mockito.when (this.service.readById(id)).thenReturn(existingPerson);
	        Mockito.when(this.service.update(id,updated)).thenReturn(updated);
	        ResponseEntity<Person> response = new ResponseEntity<Person>(updated, 
	        		HttpStatus.ACCEPTED);
	        assertThat(response).isEqualTo(this.controller.updatePerson
	        		(1L, newValues));
	        Mockito.verify(this.service, Mockito.times(1)).update(id,updated);
	    }
	
	  @Test
	  public void testDeleteById() {
		  
	  	   Person person = new Person(1L, "Russ", 80, 30, 40, 50);
	  	   Mockito.when(this.service.readById(1L)).thenReturn(person);
	  	   Mockito.when(this.service.delete(1L)).thenReturn(true);
	  	   ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(
	        		HttpStatus.NO_CONTENT);
	  	   assertThat(response).isEqualTo(this.controller.deletePerson(1L));
	  	   Mockito.verify(this.service, Mockito.times(1)).delete(1L);	  	  
	  	  }
	
}

