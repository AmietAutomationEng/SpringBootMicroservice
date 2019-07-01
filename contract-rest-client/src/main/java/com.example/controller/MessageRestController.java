package com.example.controller;

import com.example.model.Person;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
class MessageRestController {

	@RequestMapping(value = "message/getPerson", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage(@RequestParam(value = "personId") Integer personId) {
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject("http://localhost:8000/person/{personId}", Person.class, personId);
		return ResponseEntity.ok().body("Hello " + person.getFirstName());
	}

}
