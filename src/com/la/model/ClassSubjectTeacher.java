package com.la.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="class_subject_teacher")
public class ClassSubjectTeacher implements Serializable{
	
	    @Id
		@OneToMany
		@JoinColumn(name="cs_id")
	    @Cascade(value = { CascadeType.ALL })
	    List<ClassSubject> classSubjectList;
		
		@Id
		@OneToOne
		@JoinColumn(name="teacher_id")
		Teacher teacher;
		
		public ClassSubjectTeacher() {
			super();
		}		

		public ClassSubjectTeacher(List<ClassSubject> classSubjectList, Teacher teacher) {
			super();
			this.classSubjectList = classSubjectList;
			this.teacher = teacher;
		}
		
		
		public Teacher getTeacher() {
			return teacher;
		}
		
		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}

		public List<ClassSubject> getClassSubjectList() {
			return classSubjectList;
		}

		public void setClassSubjectList(List<ClassSubject> classSubjectList) {
			this.classSubjectList = classSubjectList;
		}

		
	    
//	    cs_id int,
//	    teacher_id int,
//	    creation_date date,
//	    created_by int,

}
