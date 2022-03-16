package com.example.demo.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Person;
import nl.jqno.equalsverifier.EqualsVerifier;


public class PersonTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Person.class).usingGetClass().verify();
	}
	
	@Test
	public void getAndSetTest() {
		Person person = new Person();

		person.setId(1L);
		person.setName("Richard");
		person.setBenchPressKG(50);
		person.setShoulderPressKG(30);
		person.setBicepCurlKG(20);
		person.setSquatKG(60);
		
		assertNotNull(person.getId());
		assertNotNull(person.getName());
		assertNotNull(person.getBenchPressKG());
		assertNotNull(person.getShoulderPressKG());
		assertNotNull(person.getBicepCurlKG());
		assertNotNull(person.getSquatKG());

		assertEquals(person.getId(), 1L);
		assertEquals(person.getName(), "Richard");
		assertEquals(person.getBenchPressKG(), 50);
		assertEquals(person.getShoulderPressKG(), 30);
		assertEquals(person.getBicepCurlKG(), 20);
		assertEquals(person.getSquatKG(), 60); 
	}
	
	@Test
	public void PersonConstructor() {
		Person person = new Person("Russ", 70, 30, 40, 70);
		
		assertNotNull(person.getName());
		assertNotNull(person.getBenchPressKG());
		assertNotNull(person.getShoulderPressKG());
		assertNotNull(person.getBicepCurlKG());
		assertNotNull(person.getSquatKG());
		
		assertEquals(person.getName(), "Russ");
		assertEquals(person.getBenchPressKG(), 70);
		assertEquals(person.getShoulderPressKG(), 30);
		assertEquals(person.getBicepCurlKG(), 40);
		assertEquals(person.getSquatKG(), 70);
	}
		
	@Test
	public void allArgsConstructor() {
		Person person = new Person(1L,"Russ", 70, 30, 40, 70);

		assertNotNull(person.getId());
		assertNotNull(person.getName());
		assertNotNull(person.getBenchPressKG());
		assertNotNull(person.getShoulderPressKG());
		assertNotNull(person.getBicepCurlKG());
		assertNotNull(person.getSquatKG());

		assertEquals(person.getId(), 1L);
		assertEquals(person.getName(), "Russ");
		assertEquals(person.getBenchPressKG(), 70);
		assertEquals(person.getShoulderPressKG(), 30);
		assertEquals(person.getBicepCurlKG(), 40);
		assertEquals(person.getSquatKG(), 70);
	}
	
	
	@Test
	public void toStringTest() {
		Person person = new Person (1L,"Russ", 70, 30, 40, 70);
		person.toString();
		
		equals ("Person [Id=" + 1L + ", Name=" + "Russ" + ", BenchPressKG="
		+ 70 + ", ShoulderPressKG=" + 30 + ", "
		+ "bicepCurlKG=" + 40
		+ "," + "SquatKG=" + 70 + "]");

	}
}
