package com.codingdojo.license.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.services.LicenseServices;
import com.codingdojo.license.services.PersonsServices;

@Controller
public class Licenses {
	private int currentNumber = 1;
	
	private final LicenseServices licenseService;
	private final PersonsServices personService;
	public Licenses(LicenseServices licenseService, PersonsServices personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}

	@RequestMapping("/index")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String createLicense(
			Model model, @Valid @ModelAttribute ("newlicense") License license, BindingResult result
			) {
		
				List<Person> persons =  personService.findAll();
		
				license.setNumber("output");
				currentNumber++;
				model.addAttribute("allpersons", persons);
				return "newLicense.jsp";
			}
	
	@PostMapping("/licenses/new")
	public String createdLicense(
			Model model, @Valid @ModelAttribute ("newlicense") License license, BindingResult result, 
			@RequestParam(value="myDate", defaultValue="myDate") String myDate
			) {
		license.setExpiration_date(new Date());
		
		if(result.hasErrors()) {
			System.out.println("There are errors. Please enter a valid input!");
			return "newLicense.jsp";
		} else {
//			Person thePerson = personService.findOne(id);
//			license.setPerson(thePerson);
			licenseService.addLicense(license);
			return "redirect:/index";
		}
	}
	
	public String newNumber() {
		String output = ""; 
		String num = String.format("%06d" , output);
		output = currentNumber + num; 
        return output;
	}

	public Date dateFromString(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 2019-08-09
		Date dateFromString = null;
		try {
			dateFromString = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dateFromString;
		}
	
	}
