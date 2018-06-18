package com.starxfighter.countries.models;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country_code;
	private String language;
	private String is_official;
	private float percentage;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	public Language() {
	}

	public Language(Long id, String country_code, String language, String is_official, float percentage,
			Country country) {
		this.id = id;
		this.country_code = country_code;
		this.language = language;
		this.is_official = is_official;
		this.percentage = percentage;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIs_official() {
		return is_official;
	}

	public void setIs_official(String is_official) {
		this.is_official = is_official;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
