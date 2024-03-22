package com.StudentAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	int id;
	private String firstnname, lastname;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstnname, String lastname) {
		super();
		this.id = id;
		this.firstnname = firstnname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstnname() {
		return firstnname;
	}

	public void setFirstnname(String firstnname) {
		this.firstnname = firstnname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstnname=" + firstnname + ", lastname=" + lastname + "]";
	}
	

}