package com.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.entiry.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	public Person findByName(String name);
}
