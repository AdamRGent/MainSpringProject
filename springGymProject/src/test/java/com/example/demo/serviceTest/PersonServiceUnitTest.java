package com.example.demo.serviceTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.PersonService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class PersonServiceUnitTest {
	
	@Autowired
    private PersonService service;

    @MockBean
    private PersonRepo repo;
    
    @Test
    void testCreate() {

        Person toSave = new Person("Russ", 80, 30, 40, 50);
        Person saved = new Person(1L, "Russ", 80, 30, 40, 50);
        Mockito.when(this.repo.save(toSave)).thenReturn(saved);
        Assertions.assertThat(this.service.create(toSave)).isEqualTo(saved);
        Mockito.verify(this.repo, Mockito.times(1)).save(toSave);
    }

    @Test
    void testReadById() {

        Long id = 1L;
        Person expected = new Person(id, "Russ", 80, 30, 40, 50);
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
        Assertions.assertThat(this.service.readById(id)).isEqualTo(expected);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    void testReadAll() {

        Long id = 1L;
        Person testPerson = new Person("Russ", 80, 30, 40, 50);
        testPerson.setId(id);
        List<Person> Persons = List.of(testPerson);
        Mockito.when(this.repo.findAll()).thenReturn(Persons);
        Assertions.assertThat(this.service.readAll()).isEqualTo(Persons);
        Mockito.verify(this.repo, Mockito.times(1)).findAll();

    }
    
    @Test
    void testUpdate() {

        Long id = 1L;
        Person newValues = new Person("Russ", 80, 30, 40, 50);
        Person existingPerson = new Person(id, "Russ", 80, 40, 40, 50);
        Person updated = new Person(id, "Russ", 80, 30, 40, 50);

        Mockito.when (this.repo.findById(id)).thenReturn(Optional.of(existingPerson));
        Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updated);
        assertEquals(updated, this.service.update(id, newValues));
        
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);

    }
    
    
    @Test 
    void TruetestDelete() {
    
    	Long id = 1L;
    	Mockito.when(this.repo.existsById(id)).thenReturn(false);
        assertTrue(this.service.delete(id));
        Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
    
    }
    
    @Test 
    void FalsetestDelete() {
  	   
  	   Long id = 1L;
  	   Mockito.when(this.repo.existsById(id)).thenReturn(true);
  	   assertFalse(this.service.delete(id));
  	   Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
  	   Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
  	  
  	  }
    
}


