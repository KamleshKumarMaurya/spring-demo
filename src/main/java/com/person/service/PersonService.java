package com.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.entiry.Person;
import com.person.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	public void save(Person person) {
		repo.save(person);
	}
	
	public List<Person> findAll(){
		return repo.findAll();
	}
	
	public void deletById(int id) {
		repo.deleteById(id);
	}
	
	public void update(Person person) {
		repo.save(person);
	}
	
	public Person findById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Person findByName(String name) {
		return repo.findByName(name);
	}
}
