package com.ensah.core.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ensah.core.bo.Person;
import com.ensah.core.services.IPersonService;

import javax.validation.Valid;

@Controller
public class PersonController {

	@Autowired
	private IPersonService personService;

	private Map<String, String> countryList = new HashMap<String, String>();

	public PersonController() {
		countryList.put("Morocco", "Morocco");
		countryList.put("France", "France");
		countryList.put("Spain", "Spain");

	}


	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("personModel", new Person());
		model.addAttribute("countryList", countryList);
		model.addAttribute("personList", personService.getAllPersons());
		return "form";
	}

	@RequestMapping(value = "/updatePersonForm/{idPerson}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable int idPerson, Model model) {

		model.addAttribute("personModel", personService.getPersonById(Long.valueOf(idPerson)));
		model.addAttribute("countryList", countryList);

		return "updateForm";
	}

	@RequestMapping("/updatePerson")
	public String updatePerson(@Valid @ModelAttribute("personModel") Person person, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("countryList", countryList);
			return "updateForm";
		}

		personService.updatePerson(person);
		model.addAttribute("personList", personService.getAllPersons());

		return "redirect:/managePersons";
	}

	@RequestMapping("/addPerson")
	public String process(@Valid @ModelAttribute("personModel") Person person, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("countryList", countryList);
			return "form";
		}

		personService.addPerson(person);
		model.addAttribute("personList", personService.getAllPersons());

		return "redirect:/showForm";
	}



	@RequestMapping("/managePersons")
	public String managePersons(Model model) {

		model.addAttribute("personList", personService.getAllPersons());

		return "listPersons";
	}

	@RequestMapping(value = "/deletePerson/{idPerson}", method = RequestMethod.GET)
	public String delete(@PathVariable int idPerson) {

		personService.deletePerson(Long.valueOf(idPerson));

		return "redirect:/managePersons";
	}

	public Map<String, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(Map<String, String> countryList) {
		this.countryList = countryList;
	}

}
