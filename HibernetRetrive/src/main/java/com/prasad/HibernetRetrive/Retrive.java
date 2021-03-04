package com.prasad.HibernetRetrive;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Retrive {
	@Id
private int roll;
private String name;
private String sname;
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
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
@Override
public String toString() {
	return "Retrive [roll=" + roll + ", name=" + name + ", sname=" + sname + "]";
}



}
