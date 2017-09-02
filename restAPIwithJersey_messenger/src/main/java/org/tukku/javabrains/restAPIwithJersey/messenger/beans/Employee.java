package org.tukku.javabrains.restAPIwithJersey.messenger.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private Long empId;
	private String name;	
	private String dept;
	private Date joiningDate = Calendar.getInstance().getTime();
	private List<Links> links=new ArrayList<Links>();
	
	public Employee(){
		
	}
	public Employee(Long empId,String name,String dept){
		this.empId = empId;
		this.name = name;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getEmpId() {
		return empId;
	}	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public List<Links> getLinks() {
		return links;
	}
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	public void addLink(String uri,String ref) {
		this.links.add(new Links(uri,ref));
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", joiningDate=" + joiningDate
				+ ", links=" + links + "]";
	}	
	
	
}
