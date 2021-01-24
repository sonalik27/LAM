package com.la.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="country_name")
	private String countryName;
	
	public Country() {
		super();
	}
	
	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}
	
	
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCountryId() {
		return countryId;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	  
	
//	  country_id int primary key auto_increment,
//	  country_name varchar(20) not null
}
