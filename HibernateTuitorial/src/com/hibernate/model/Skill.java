package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Skill implements Serializable{
	private String skill;
	private int yrsOfExp;
	
	public Skill(){
		
	}
	public Skill(String skill, int i) {
		this.skill=skill;
		this.yrsOfExp=i;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getYrsOfExp() {
		return yrsOfExp;
	}
	public void setYrsOfExp(int yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}
	/*@Override
	public String toString() {
		return "Skill [skill=" + skill + ", yrsOfExp=" + yrsOfExp + "]";
	}*/

}
