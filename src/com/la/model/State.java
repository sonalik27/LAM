package com.la.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	int stateId;
	
	@Column(name="state_name")
	String stateName;
	
	@OneToOne
	@JoinColumn(name="country_id")
	Country country;
	
	

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getStateId() {
		return stateId;
	}
	
	
//	 state_id int primary key auto_increment,
//	  state_name varchar(20) not null,
//	  country_id int ,
//	  constraint fk_country_id foreign key (country_id) references country(country_id)
}
