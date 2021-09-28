package com.springmvcountries.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcountries.demo.models.Country;
import com.springmvcountries.demo.services.CountryService;

@Controller
public class HomeController {

	@Autowired CountryService service;
	
	@RequestMapping("/")
	public String viewListCountryPage(Model model) {
		List<Country> countries = service.listAll();
		model.addAttribute("countries", countries);
		return "index";
	}
	
	@RequestMapping("/details/{id}")
	public String viewCountryInfoPage(@PathVariable("id") int id, Model model) {
		Country country = service.get(id);
		model.addAttribute("country", country);
		return "info_country";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult result) {
		if (result.hasErrors()) {
			return "edit_country";
		}else {
			service.save(country);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditCountryPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");
		Country country = service.get(id);
		mav.addObject("country", country);
		mav.addObject("readonly", "readonly");
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCountry(@PathVariable("id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/new")
	public String viewNewProductPage(Model model) {
		Country country = new Country();
		model.addAttribute("country", country);
		return "edit_country";
	}

}
