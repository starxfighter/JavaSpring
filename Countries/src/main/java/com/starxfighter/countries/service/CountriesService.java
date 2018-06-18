package com.starxfighter.countries.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.starxfighter.countries.models.Country;
import com.starxfighter.countries.repos.CityRepository;
import com.starxfighter.countries.repos.CountryRepository;
import com.starxfighter.countries.repos.LanguageRepository;

@Service
public class CountriesService {
	
	private final CityRepository cityRepo;
	private final CountryRepository countryRepo;
	private final LanguageRepository languageRepo;
	
	public CountriesService(CityRepository cityRepo, CountryRepository countryRepo, LanguageRepository languageRepo) {
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
	}
	
	public List<Object[]> slovene(){
		return countryRepo.findSlovene();
	}
	
	public List<Object[]> countCities(){
		return countryRepo.countCities();
	}
	
	public List<Object[]> mexCiries(){
		return countryRepo.mexCities(); 
	}
	
	public List<Object[]> langPerct(){
		return countryRepo.langPerct();
	}
	
	public List<Object[]> surfArea(){
		return countryRepo.surfArea();
	}
	
	public List<Object[]> constMon(){
		return countryRepo.constMon();
	}
	
	public List<Object[]> argCity(){
		return countryRepo.argCity();
	}
	
	public List<Object[]> region(){
		return countryRepo.region();
	}

}



