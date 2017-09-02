package com.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;
import com.hibernate.model.Vehicle;

public class TestRun {

	public static void main(String[] args) {

		SessionFactory factory  = createSessionfactory();
		//creating session object  
		Session session=factory.openSession();
		//creating transaction object  
		Transaction t=session.beginTransaction();  
		try{
			Employee e1 = PlayWithEmployee.createEmp(session);
			Integer i = (Integer) session.save(e1); 
			//Integer j = (Integer) session.save(e1.getVehicle());  //For OneToOne mapping
			/*session.save(e1.getVehicleList().toArray()[0]);
		session.save(e1.getVehicleList().toArray()[1]);
			 */
			/*session.save(e1.getVehicleList1().toArray()[0]);
		session.save(e1.getVehicleList1().toArray()[1]);
			 */
			
			/*session.save(e1.getVehicleList2().toArray()[0]);
			session.save(e1.getVehicleList2().toArray()[1]);
			*/
			Vehicle v=new Vehicle("indica");
			Integer k = (Integer) session.save(v);
			
			t.commit(); // session.getTransaction().commit(); 
			session.close();
			System.out.println("*******SAVED***************");

			session =factory.openSession();
			Employee e2=(Employee) session.get(Employee.class, i);
			System.out.println(e2.getContacts());
			System.out.println(e2.getSkills().get(0));//Lazily fetch type when called get(0)

			
			Vehicle v1=(Vehicle) session.get(Vehicle.class, k+1);
			System.out.println(v1);
			
			session.close();
			/*Throws  org.hibernate.LazyInitializationException
			 * System.out.println(e2.getContacts());
		System.out.println(e2.getSkills().get(0));//Lazily fetch type when called get(0)		
			 */
		}
		finally{
			if(session.isOpen())
				session.close();
			if(!factory.isClosed())
				factory.close();
		}
	}

	private static SessionFactory createSessionfactory() {
		//creating configuration object  
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

		//creating seession factory object  

		//1>// SessionFactory factory=cfg.buildSessionFactory();  
		/*
		 * hibeernate 4.0,4.1,4.2 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            configuration.getProperties()). buildServiceRegistry();
		 */
		//3>hibbernate 4.3//
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		return factory;
	}

}
