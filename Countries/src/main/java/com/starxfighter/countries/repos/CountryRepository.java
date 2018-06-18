package com.starxfighter.countries.repos;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

	
	//select country.name, countrylanguage.language, countrylanguage.Percentage
	//from country
	//left join countrylanguage on country.code = countrylanguage.countrycode
	//where countrylanguage.language = 'Slovene' 
	//order by country.name desc;
	//
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' Order By c.name desc")
	List<Object[]> findSlovene();
	
	//select country.name, count(*) as num_of_cities
	//from country
	//left join city on country.code = city.countrycode
	//group by country.name
	//order by country.name desc;
	@Query("Select c.name, count(ct) as num_of_cities FROM Country c Join c.cities ct GROUP BY c.name ORDER BY c.name desc")
	List<Object[]> countCities();
	
	//select city.name, city.population
	//from country 
	//left join city on country.code = city.CountryCode
	//where city.population > 500000 and country.code = "MEX"
	//order by city.population desc;
	@Query("SELECT ct.name, ct.population FROM Country c JOIN c.cities ct WHERE ct.population > 500000 and c.code = 'MEX' ORDER BY ct.population desc")
	List<Object[]> mexCities();
	
	//select country.name, cl.Language, cl.Percentage
	//from country
	//left join countrylanguage as cl on country.code = cl.CountryCode
	//where cl.Percentage >= 89.0
	//order by cl.Percentage desc, country.name asc;
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= 89.0 ORDER BY l.percentage desc, c.name asc")
	List<Object[]> langPerct();
	
	//select country.name, country.SurfaceArea as surface_area, country.population
	//from country
	//where country.SurfaceArea < 501 and country.population > 100000
	//order by country.name asc;
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501  and c.population > 100000 ORDER BY c.name asc")
	List<Object[]> surfArea();
	
	//select country.name, country.GovernmentForm as Government, country.Capital, country.LifeExpectancy as Life_Exp
	//from country
	//where country.GovernmentForm = "Constitutional Monarchy" and country.capital > 200 and country.LifeExpectancy >= 75.0
	//order by country.name asc;
	@Query("SELECT c.name, c.government_form, c.capital, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' and c.capital > 200 and c.life_expectancy >=75.0 ORDER BY c.name asc")
	List<Object[]> constMon();
	
	//select country.name, city.name, city.District, city.Population
	//from country
	//left join city on country.code = city.CountryCode
	//where country.code = "ARG" and city.District = "Buenos Aires" and city.population >= 500000
	//order by city.name asc; 
	@Query("SELECT c.name, ct.name, ct.district, ct.population FROM Country c JOIN c.cities ct WHERE c.code='ARG' and ct.district='Buenos Aires' and c.population > 500000 ORDER BY ct.name asc")
	List<Object[]> argCity();
	
	//select region, count(*) as Countries
	//from country
	//group by region
	//order by countries desc;
	@Query("SELECT c.region, count(c) as countries FROM Country c GROUP BY c.region ORDER BY countries desc")
	List<Object[]> region();
	
}
