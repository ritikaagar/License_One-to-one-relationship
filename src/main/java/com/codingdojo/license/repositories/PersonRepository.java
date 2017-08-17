package com.codingdojo.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.license.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{



}
