package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String ssn_id, String customer_name, int age, String address, String state,
			String city) {
		super();
		this.customer_id = customer_id;
		this.ssn_id = ssn_id;
		this.customer_name = customer_name;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer customer_id;
	
	String ssn_id;
	
	String customer_name;
	
	Integer	age;
	
	String address;
	
	String state;
	
	String city;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getSsn_id() {
		return ssn_id;
	}

	public void setSsn_id(String ssn_id) {
		this.ssn_id = ssn_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

}
