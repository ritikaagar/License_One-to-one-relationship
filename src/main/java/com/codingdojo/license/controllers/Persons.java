package com.codingdojo.license.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.license.models.Person;
import com.codingdojo.license.services.PersonsServices;

@Controller
public class Persons {
	
	//Import services
	private final PersonsServices personService;
	public Persons(PersonsServices personService) {
		this.personService = personService;
	}
	

	@RequestMapping("persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person,
    		BindingResult result) {
		
		return "newPerson.jsp";
	}
	
	@PostMapping("persons/new")
	public String  creatingPerson(Model model, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("we have errors doing person");
			return "person_new.jsp";
		} else {
			personService.addPerson(person);
			return "redirect:/index";
		}
	}
}
