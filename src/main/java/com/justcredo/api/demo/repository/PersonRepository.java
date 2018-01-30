package com.justcredo.api.demo.repository;

import java.util.Collection;

import com.justcredo.api.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	Collection<Person> findAll();
	
	Person findByUsername(String username);

}
