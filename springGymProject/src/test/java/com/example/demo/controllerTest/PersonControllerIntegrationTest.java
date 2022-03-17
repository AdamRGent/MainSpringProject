package com.example.demo.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.Person;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc 

@ActiveProfiles("test") 

@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:person-schema.sql",
"classpath:person-data.sql" })


public class PersonControllerIntegrationTest {

	
	@Autowired 
	private MockMvc mvc; 

	@Autowired
	private ObjectMapper mapper; 

	
	@Test
	public void testCreate() throws Exception {
		
		Person testPerson = new Person ("Thor", 200, 150, 100, 100);
		String testPersonAsJSON = this.mapper.writeValueAsString(testPerson);
		RequestBuilder req = post("/Person/create").content(testPersonAsJSON).contentType
				(MediaType.APPLICATION_JSON);

		Person testSavedPerson = new Person(3, "Thor", 200, 150, 100, 100);
		String testSavedPersonAsJSON = this.mapper.writeValueAsString(testSavedPerson);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedPersonAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	public void testCreate2() throws Exception {
		Person testPerson = new Person("ag", 30, 20, 10, 40);
		String testPersonAsJSON = this.mapper.writeValueAsString(testPerson);
		RequestBuilder req = post("/Person/create").content(testPersonAsJSON).contentType
				(MediaType.APPLICATION_JSON);
		Person testSavedPerson = new Person(3, "ag", 30, 20, 10, 40);
		String testSavedPersonAsJSON = this.mapper.writeValueAsString(testSavedPerson);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedPersonAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/Person/readById/1");

		ResultMatcher checkStatus = status().isOk();

		Person savedPerson = new Person(1, "Becky", 30, 10, 20, 40);
		String savedPersonAsJSON = this.mapper.writeValueAsString(savedPerson);

		ResultMatcher checkBody = content().json(savedPersonAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	public void testReadAll() throws Exception {
		Person entry = new Person(1, "Becky", 30, 10, 20, 40);
		Person entry1 = new Person(2, "Adam", 100, 40, 40, 120);
		List<Person> persons = new ArrayList<>();
		persons.add(entry);
		persons.add(entry1);
		String personsOutputAsJson = this.mapper.writeValueAsString(persons);
		
		this.mvc.perform(get("/Person/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(personsOutputAsJson));
	}
	
	
	@Test
    public void testUpdate() throws Exception {
        final Person newPerson = new Person("Adam", 120, 40, 40, 140);
        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
        
                this.mvc.perform(put("/Person/update/2").contentType(MediaType.APPLICATION_JSON)
                    .content(this.mapper.writeValueAsString(newPerson)))
                	.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

        Person result = this.mapper.readValue(newPersonAsJSON, Person.class);
        assertThat(result).isEqualTo(newPerson);
    }
	
	
	@Test
	public void testDeleteByID() throws Exception {
		this.mvc.perform(delete("/Person/delete/2")
				.contentType (MediaType.APPLICATION_JSON))
				.andExpect (status().isNoContent());
	}
	
	
}
