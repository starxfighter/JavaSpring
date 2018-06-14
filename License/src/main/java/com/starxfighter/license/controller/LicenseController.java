package com.starxfighter.license.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starxfighter.license.models.License;
import com.starxfighter.license.models.Person;
import com.starxfighter.license.service.LicenseService;

@Controller
public class LicenseController {
	
	public final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/license/Index.jsp";
	}
	
	@RequestMapping("/person/new")
	public String newperson(@ModelAttribute("person") Person person) {
		return "/license/NewPerson.jsp";
	}
	
	@RequestMapping(value="/person/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/license/NewPerson.jsp";
		} else {
			licenseService.createPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/license/new")
	public String newlicense(@ModelAttribute("license") License license, Model model) {
		List<Person> tempPerson = licenseService.allPerson();
		model.addAttribute("person", tempPerson);
		return "/license/NewLicense.jsp";
	}
	
	@RequestMapping(value="/license/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, @RequestParam("expirationDate") String expireDate) {
		License lastEntry = licenseService.findLast();
		if(lastEntry == null) {
			String setString = "000001";
			license.setNumber(setString);
		} else {
			int tempNum = Integer.parseInt(lastEntry.getNumber());
			tempNum++;
			String setString = Integer.toString(tempNum);
			String setLicense = String.format("%6s", setString);
			setLicense = setLicense.replace(" ", "0");
			license.setNumber(setLicense);
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			Date tempDate = format.parse(expireDate);
			license.setExpireDate(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(result.hasErrors()) {
			System.out.println("found Error");
			System.out.println("result" + result);
			return "/license/NewLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/person/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = licenseService.findPerson(id);
		License license = licenseService.findLicense(id);
		model.addAttribute("license", license);
		model.addAttribute("person", person);
		return "/license/Show.jsp";
	}
	
		
//end
}
