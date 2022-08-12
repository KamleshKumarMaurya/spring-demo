package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.entiry.Person;
import com.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@PostMapping("/")
	public ResponseEntity<Person> save(@RequestBody Person person){
		service.save(person);
		return new ResponseEntity<Person>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<Person> viewAllPerson(){
		return service.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable int id){
		Person p1 = service.findById(id);
		p1.setId(person.getId());
		p1.setName(person.getName());
		p1.setAge(person.getAge());
		p1.setEducation(person.getEducation());
		p1.setJod(person.getJod());
		service.update(p1);
		return new ResponseEntity<Person>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Person> deleteById(@PathVariable int id){
		service.deletById(id);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@GetMapping("/ById/{id}")
	public Person findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/Byname/{name}")
	public Person findByName(@PathVariable String name) {
		return service.findByName(name);
	}

}
