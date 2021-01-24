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
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	int studentId;

	@Column(name = "student_name")
	String studentName;

	@Column(name = "address_line1")
	String addressLine1;

	@Column(name = "address_line2")
	String addressLine2;

	@Column(name = "dob")
	String dob;

	@OneToOne
	@JoinColumn(name="city_id")
	City city;

	@OneToOne
	@JoinColumn(name="state_id")
	State state;

	@OneToOne
	@JoinColumn(name="country_id")
	Country country;

	@OneToOne 
	@JoinColumn(name="class_id")
	Class aclass;

	public Student() {
		super();
	}

	public Student(String studentName, String addressLine1, String addressLine2, String dob, City city, State state,
			Country country, Class aclass) {
		super();
		this.studentName = studentName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.country = country;
		this.aclass = aclass;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getStudentId() {
		return studentId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Class getAclass() {
		return aclass;
	}

	public void setAclass(Class aclass) {
		this.aclass = aclass;
	}
	
	

//	student_id int primary key auto_increment,
//	  student_name varchar(60) not null,
//	  address_line1 varchar(30) not null,
//	  address_line2 varchar(30),
//	  city_id int,
//	  state_id int,
//	  country_id int,
//	  class_id int,
//	  dob varchar(15), #DD/MM/YYYY

}
