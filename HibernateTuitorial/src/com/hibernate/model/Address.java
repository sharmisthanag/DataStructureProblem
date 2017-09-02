package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Address implements Serializable{
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="PINCODE")
	private int pincode;
	
	@Column(name="STATE")
	private String state;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/*@Override
	public String toString() {
		return "Address [street=" + street + ", pincode=" + pincode + ", state=" + state + "]";
	}*/
	
}
