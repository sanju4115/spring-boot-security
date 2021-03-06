package com.justcredo.api.demo.service;

import com.justcredo.api.demo.model.Person;
import com.justcredo.api.demo.repository.PersonRepository;
import com.justcredo.api.demo.service.BuddyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkingBuddyService implements BuddyService {
	
	private PersonRepository repository;
	
	@Autowired
	public DrinkingBuddyService(PersonRepository repository) {
		this.repository = repository;
	}

	/**
	 * Finds and returns person with smallest age difference to the input.
	 */
	@Override
	public Person findBuddy(Person person) {
		Person buddy = null;
		
		for (Person p : repository.findAll()) {
			// do not return same person or person without age
			if (p.getId() == person.getId() || p.getAge() == 0) {
				continue;
			}
			
			// no buddy? Take the first one
			if (buddy == null) {
				buddy = p;
			}
			
			int buddyDiff = Math.abs(person.getAge() - buddy.getAge());
			int currentDiff = Math.abs(person.getAge() - p.getAge());
			
			// found someone closer to this person's age
			if (currentDiff < buddyDiff) {
				buddy = p;
			}
		}
		
		return buddy;
	}

}
