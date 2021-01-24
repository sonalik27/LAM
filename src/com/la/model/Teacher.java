package com.la.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	int teacherId;

	@Column(name = "teacher_name")
	String teacherName;

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
		
    @OneToMany
    @JoinColumn(name="teacher_id")
	List<ClassSubjectTeacher> classSubjectList;

	public Teacher() {
		super();
	}

	public Teacher(String teacherName, String addressLine1, String addressLine2, String dob, City city, State state,
			Country country, List<ClassSubjectTeacher> classSubjectList) {
		super();
		this.teacherName = teacherName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.country = country;
		this.classSubjectList = classSubjectList;
	}	
	
	

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public int getTeacherId() {
		return teacherId;
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

	public List<ClassSubjectTeacher> getClassSubjectList() {
		return classSubjectList;
	}

	public void setClassSubjectList(List<ClassSubjectTeacher> classSubjectList) {
		this.classSubjectList = classSubjectList;
	}
	

//	teacher_id int primary key auto_increment,
//	  teacher_name varchar(60) not null,
//	  address_line1 varchar(30) not null,
//	  address_line2 varchar(30),
//	  city_id int,
//	  state_id int,
//	  country_id int,
//	  class_id int,
//	  dob varchar(15), #DD/MM/YYYY

}
