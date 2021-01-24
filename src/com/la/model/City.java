package com.la.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	int cityId;

	@Column(name = "city_name")
	String cityName;

	@OneToOne
	@JoinColumn(name = "state_id")
	@NotFound (action = NotFoundAction.IGNORE)
	State state;

	public City() {
		super();
	}

	public City(String cityName, State state) {
		super();
		this.cityName = cityName;
		this.state = state;
	}
	

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

//	 city_id int primary key auto_increment,
//     city_name varchar(20) not null,
//     state_id int,
//     constraint fk_state_id foreign key (state_id) references state(state_id)

}
