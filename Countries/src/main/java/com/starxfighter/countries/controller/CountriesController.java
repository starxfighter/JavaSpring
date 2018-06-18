package com.starxfighter.countries.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starxfighter.countries.models.Country;
import com.starxfighter.countries.models.Language;
import com.starxfighter.countries.service.CountriesService;

@Controller
public class CountriesController {
	
	private final CountriesService countriesService;
	
	public CountriesController(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
	
	@RequestMapping("/")
	public void index() {
		List<Object[]> temp = countriesService.region();
		for(Object[] row : temp) {
			String tempReg = (String) row[0];
			Long tempCount = (Long) row[1];
			System.out.println("Region " + tempReg);
			System.out.println("Count " + tempCount);
		}
		return;
	}
	
//	Query 7
//	public void index() {
//		List<Object[]> test = countriesService.argCity();
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			String tempCity = (String) row[1];
//			String tempDist = (String) row[2];
//			int tempPop = (int) row[3];
//			System.out.println("Country Name " + tempName);
//			System.out.println("City Name " + tempCity);
//			System.out.println("District " + tempDist);
//			System.out.println("Populaton " + tempPop);
//		}
//		return;
//	}
//	Query 6
//	public void idex() {
//		List<Object[]> test = countriesService.constMon();
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			System.out.println("Country Name " + tempName);
//			String tempGForm = (String) row[1];
//			System.out.println("Government Form " + tempGForm);
//			int tempCap = (int) row[2];
//			System.out.println("Capital " + tempCap);
//			float tempLife = (float) row[3];
//			System.out.println("Life Expectancy" + tempLife);
//		}
//		return;
//	}
	
//	Query 5
//	public void index() {
//		List<Object[]> test = countriesService.surfArea();
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			System.out.println("Country Name " + tempName);
//			float tempArea = (float) row[1];
//			System.out.println("Surface Area " + tempArea);
//			int tempPop = (int) row[2];
//			System.out.println("Population " + tempPop);
//		}
//		return;
//	}
	
//	Query 4
//	public void index() {
//		List<Object[]> test = countriesService.langPerct();
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			System.out.println("Country Name " + tempName);
//			String tempLang = (String) row[1];
//			System.out.println("Language " + tempLang);
//			float tempPerct = (float) row[2];
//			System.out.println("Percentage " + tempPerct);
//		}
//		return;
//	}


	
//	Query 2
//	public void index(){
//		List<Object[]> test = countriesService.countCities();
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			System.out.println("Country Name " + tempName);
//			Long tempCount = (Long) row[1];
//			System.out.println("City count" + tempCount);
//		}
//		return;
//	}
	
	
//	Query 1
//	public List<Object[]> index() {
//		List<Object[]> test = countriesService.slovene();
//		System.out.println("Test" + test);
//		for(Object[] row : test) {
//			String tempName = (String) row[0];
//			System.out.println("Country Name " + tempName);
//			String tempLang = (String) row[1];
//			System.out.println("Language " + tempLang);
//			float tempPer = (float) row[2];
//			System.out.println("Percentage " + tempPer);
//
//		}
//		return countriesService.slovene();
//	}
	

}
