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
@Table(name="class_subject")
public class ClassSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cs_id")
	int csId;
	
	@OneToOne
	@JoinColumn(name="class_id")
	Class aClass;
	
	@OneToOne
	@JoinColumn(name="subject_id")
	Subject subject;
	
	public ClassSubject() {
		super();
	}

	public ClassSubject(Class aClass, Subject subject) {
		super();
		this.aClass = aClass;
		this.subject = subject;
	}

	public int getCsId() {
		return csId;
	}

	public Class getaClass() {
		return aClass;
	}

	public void setaClass(Class aClass) {
		this.aClass = aClass;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		ClassSubject cs = (ClassSubject) obj;
		if(this.csId>0 && cs.csId>0 && this.csId == cs.csId) {
			return true;
		}
		return false;
//		else if(this.subject.getSubjectId()==cs.subject.getSubjectId())
//		}
//		return super.equals(obj);
	}	
	
	

}
