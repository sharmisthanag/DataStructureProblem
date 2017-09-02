package com.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Veh_FourWheeler")
@Table
@DiscriminatorValue("4Wheeler")
public class FourWheeler extends Vehicle{
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	@Override
	public String toString() {
		return "FourWheeler [steeringWheel=" + steeringWheel + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getEmp()=" + getEmp() + ", getEmpList()=" + getEmpList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
