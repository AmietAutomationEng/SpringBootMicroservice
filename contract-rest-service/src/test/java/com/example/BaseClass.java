package com.example;

import com.example.controller.PersonRestController;
import com.example.model.Person;
import com.example.service.CreatePersonService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractRestServiceApplication.class)
public abstract class BaseClass {

	@Autowired
	PersonRestController personRestController;

	@MockBean
	CreatePersonService createPersonService;

	@Before public void setup() {
		RestAssuredMockMvc.standaloneSetup(personRestController);

		Mockito.when(createPersonService.findPersonById(1))
				.thenReturn(new Person(1, "foo", "bee"));
	}

}
