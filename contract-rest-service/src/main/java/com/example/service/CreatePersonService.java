package com.example.service;

import java.util.HashMap;
import java.util.Map;

import com.example.model.Person;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonService {

	private final Map<Integer, Person> personMap;
	
	public CreatePersonService() {
		personMap = new HashMap<>();
		personMap.put(1, new Person(1, "Richard", "Gere"));
		personMap.put(2, new Person(2, "Emma", "Choplin"));
		personMap.put(3, new Person(3, "Anna", "Carolina"));
	}
	
	public Person findPersonById(Integer id) {
		return personMap.get(id);
	}
}
