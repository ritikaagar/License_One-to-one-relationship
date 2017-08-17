package com.codingdojo.license.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.Person;
import com.codingdojo.license.repositories.LicenseRepository;
import com.codingdojo.license.repositories.PersonRepository;

@Service
public class PersonsServices {
private PersonRepository personRepository;
	
	public PersonsServices (PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll(){
		return (List<Person>) personRepository.findAll();
	}
	
	public Person findOne(Long id) {
		return personRepository.findOne(id);
	}
	
	public void addPerson(Person person) {
		personRepository.save(person);
	}
}
