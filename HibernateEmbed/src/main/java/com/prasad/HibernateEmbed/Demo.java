package com.prasad.HibernateEmbed;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Embededwork")
public class Demo {
	@Id
private int id;
private Embed name;
private String number;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Embed getName() {
	return name;
}
public void setName(Embed name) {
	this.name = name;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

}
