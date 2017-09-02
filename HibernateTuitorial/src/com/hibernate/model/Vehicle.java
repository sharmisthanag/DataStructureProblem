package com.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity(name="vehicle")
@Table(name="EMP_VEHICLE")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="VEHICLE_TYPE")
//@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)

@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)

@NamedQuery(name ="getAllEmployee",query="from vehicle")
@NamedNativeQuery(name="getAllEmployee_native", query = "select * from EMP_VEHICLE",resultClass=Vehicle.class)
public class Vehicle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private int id;
	private String name;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@NotFound(action=NotFoundAction.IGNORE)
	private Employee emp;
	
	@Transient
	@ManyToMany
	private Collection<Employee> empList=new ArrayList<>();
	
	public Vehicle(){
		
	}
	public Vehicle(String name){
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Collection<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(Collection<Employee> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", empList=" + empList + "]";
	}
	

}
/*
Table per class
Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
Hibernate: insert into Veh_FourWheeler (emp_id, name, steeringWheel, id) values (?, ?, ?, ?)
Hibernate: insert into Veh_TwoWheeler (emp_id, name, steeringHandle, id) values (?, ?, ?, ?)
*/
/*
 * Single table -> when discriminator value is also presnt
 * Hibernate: insert into EMP_VEHICLE (emp_id, name, VEHICLE_TYPE, id) values (?, ?, 'vehicle', ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, steeringWheel, VEHICLE_TYPE, id) values (?, ?, ?, '4Wheeler', ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, steeringHandle, VEHICLE_TYPE, id) values (?, ?, ?, '2Wheeler', ?)
 */
/*
 * JOINED -> when discriminator value is also presnt
 * Hibernate: insert into EMP_VEHICLE (emp_id, name, VEHICLE_TYPE, id) values (?, ?, 'vehicle', ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, VEHICLE_TYPE, id) values (?, ?, '4Wheeler', ?)
Hibernate: insert into Veh_FourWheeler (steeringWheel, id) values (?, ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, VEHICLE_TYPE, id) values (?, ?, '2Wheeler', ?)
Hibernate: insert into Veh_TwoWheeler (steeringHandle, id) values (?, ?)

If discriminator column is not mentioned in Vehicle class,the the column VEHICLE_TYPE will not get created
Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
Hibernate: insert into Veh_FourWheeler (steeringWheel, id) values (?, ?)
Hibernate: insert into EMP_VEHICLE (emp_id, name, id) values (?, ?, ?)
Hibernate: insert into Veh_TwoWheeler (steeringHandle, id) values (?, ?)
 */
