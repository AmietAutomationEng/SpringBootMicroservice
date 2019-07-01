package com.example.controller;

import com.example.model.Person;
import com.example.service.CreatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

    @Autowired
    private CreatePersonService createPersonService;

    public PersonRestController(CreatePersonService createPersonService) {
        this.createPersonService = createPersonService;
    }

    @GetMapping("/person/{id}")
    public Person findPersonById(@PathVariable("id") Integer id) {
        return createPersonService.findPersonById(id);
    }
}
