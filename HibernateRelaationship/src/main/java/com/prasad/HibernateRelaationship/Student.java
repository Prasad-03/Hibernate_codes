package com.prasad.HibernateRelaationship;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int roll;
	private String name;
	private int marks;
//	@OneToOne
//	private Laptop lapy;
	@OneToMany(mappedBy = "stud",fetch = FetchType.EAGER)
	private List<Laptop> lapy=new ArrayList<Laptop>();
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public List<Laptop> getLapy() {
		return lapy;
	}
	public void setLapy(List<Laptop> lapy) {
		this.lapy = lapy;
	}
	
	

}
