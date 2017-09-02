package com.hibernate.run;

import org.hibernate.Session;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.model.Skill;
import com.hibernate.model.Vehicle;

public class PlayWithEmployee {

	public static Employee createEmp(Session session) {
		Employee e1=new Employee();  
		//e1.setId(115);  
		e1.setFirstName("Sharmistha");  
		e1.setLastName("Nag");
		Address homeadd= new Address();
		homeadd.setPincode(734429);
		homeadd.setState("WestBengal");
		homeadd.setStreet("Naxalbari");
		e1.setHomeAddress(homeadd); 

		Address offadd= new Address();
		homeadd.setPincode(560037);
		homeadd.setState("Karnataka");
		homeadd.setStreet("Manyata");
		e1.setOfficeAddress(offadd);
		
		Vehicle v1=new Vehicle("Innova2");v1.getEmpList().add(e1);v1.setEmp(e1);
		Vehicle v2=new Vehicle("Xylo2");v2.getEmpList().add(e1);v2.setEmp(e1);
		e1.getVehicleList2().add(v1);
		e1.getVehicleList2().add(v2);
			
		
		//SavingCollection:
		e1.getContacts().add(8902472962L);e1.getContacts().add(7829847880L);
		
		e1.getSkills().add(new Skill("Java",6));e1.getSkills().add(new Skill("Hibernate",6));
		
	
	 
		
		
		return e1;
	}

}
