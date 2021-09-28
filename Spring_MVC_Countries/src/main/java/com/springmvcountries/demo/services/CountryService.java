package com.springmvcountries.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcountries.demo.models.Country;
import com.springmvcountries.demo.repo.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;
	
	public List<Country> listAll(){
		return repository.findAll();
	}
	
	public void save(Country country) {
		repository.save(country);
	}
	
	public Country get(int id) {
		return repository.findById(id).get();
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
