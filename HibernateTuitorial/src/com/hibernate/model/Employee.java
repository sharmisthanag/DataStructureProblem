package com.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="employee")
@Table(name="EMPLOYEE")
public class Employee {  
	@Id
	@GeneratedValue
	/*@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@GeneratedValue(generator = "hilo-gen")*/
	private int id; 
	
	/*@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String uuID;
	*/
	private String firstName;
	private String lastName;

	//@EmbeddedId
	@Transient
	private Address homeAddress; //this filed will not get saved is annotated with Transient


	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name="OFC_STREET"), name = "street") ,
			@AttributeOverride(column = @Column(name="OFC_STATE"), name = "state") ,
			@AttributeOverride(column = @Column(name="OFC_PINCODE"), name = "pincode") })
	private Address officeAddress;

	@ElementCollection(fetch=FetchType.EAGER)//separte table with Employee_Id as foreign key
	@JoinTable(name="EMPLOYEE_CONTACTS",
		       joinColumns=@JoinColumn(name="EMP_ID"))//insert into EMPLOYEE_CONTACTS (EMP_ID, contacts) values (?, ?)
	private Set<Long> contacts = new HashSet<>();

	@ElementCollection
	@JoinTable(name="EMPLOYEE_SKILL",
			   joinColumns=@JoinColumn(name="EMP_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns={@Column(name="SKILL_ID")}, generator = "hilo-gen", type = @Type(type="long"))
	private List<Skill> skills = new ArrayList<>(); 

	@Transient
	@OneToOne
	private Vehicle vehicle;
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, vehicle_id, id) values (?, ?, ?, ?, ?, ?, ?)
	 * Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	 * Hibernate: update EMPLOYEE set firstName=?, lastName=?, OFC_PINCODE=?, OFC_STATE=?, OFC_STREET=?, vehicle_id=? where id=?
	 */
	
	@Transient
	@OneToMany//Only OneToMany,ManyToOne mapping not annotated in Vehicle class
	private Collection<Vehicle> vehicleList = new ArrayList<>();
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, id) values (?, ?, ?, ?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList_id) values (?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList_id) values (?, ?)
	 */
	@Transient
	@OneToMany//OneToMany and ManyToOne is annotated 
	private Collection<Vehicle> vehicleList1 = new ArrayList<>();
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, id) values (?, ?, ?, ?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList1_id) values (?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList1_id) values (?, ?)
	 */
	
	
	@OneToMany(mappedBy="emp",cascade=CascadeType.ALL)//OneToMany with mapped value and ManyToOne  in vehile
	private Collection<Vehicle> vehicleList2 = new ArrayList<>();
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, id) values (?, ?, ?, ?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)

	 */
	@Transient
	@ManyToMany//ManyToMany and ManyToOne is annotated 
	private Collection<Vehicle> vehicleList3 = new ArrayList<>();
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, id) values (?, ?, ?, ?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList3_id) values (?, ?)
	   Hibernate: insert into EMPLOYEE_EMP_VEHICLE (EMPLOYEE_id, vehicleList3_id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE_EMPLOYEE (EMP_VEHICLE_id, empList_id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE_EMPLOYEE (EMP_VEHICLE_id, empList_id) values (?, ?)//this table gets created when employee object is also set the vehicle employeelist
	 */
	@Transient
	@ManyToMany(mappedBy="empList")//ManyToMany and ManyToOne is annotated 
	private Collection<Vehicle> vehicleList4 = new ArrayList<>();
	/*
	 * Hibernate: insert into EMPLOYEE (firstName, lastName, OFC_PINCODE, OFC_STATE, OFC_STREET, id) values (?, ?, ?, ?, ?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE (name, id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE_EMPLOYEE (EMP_VEHICLE_id, empList_id) values (?, ?)
	   Hibernate: insert into EMP_VEHICLE_EMPLOYEE (EMP_VEHICLE_id, empList_id) values (?, ?)//this table gets created when employee object is also set the vehicle employeelist
	   Table EMPLOYEE_EMP_VEHICLE is not created as mappedBy is mentioned in Employee class
	 */
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {  
		return id;  
	}  
	public void setId(int id) {  
		this.id = id;  
	} 

	public String getFirstName() {  
		return firstName;  
	}  
	public void setFirstName(String firstName) {  
		this.firstName = firstName;  
	}  
	public String getLastName() {  
		return lastName;  
	}  
	public void setLastName(String lastName) {  
		this.lastName = lastName;  
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Set<Long> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Long> contacts) {
		this.contacts = contacts;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	/*public String getUuID() {
		return uuID;
	}
	public void setUuID(String uuID) {
		this.uuID = uuID;
	}*/
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public Collection<Vehicle> getVehicleList1() {
		return vehicleList1;
	}
	public void setVehicleList1(Collection<Vehicle> vehicleList1) {
		this.vehicleList1 = vehicleList1;
	}
	
	public Collection<Vehicle> getVehicleList2() {
		return vehicleList2;
	}
	public void setVehicleList2(Collection<Vehicle> vehicleList2) {
		this.vehicleList2 = vehicleList2;
	}
	public Collection<Vehicle> getVehicleList3() {
		return vehicleList3;
	}
	public void setVehicleList3(Collection<Vehicle> vehicleList3) {
		this.vehicleList3 = vehicleList3;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	 


}  