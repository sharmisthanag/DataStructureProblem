package com.hibernate.run;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Vehicle;

/*
 * Basically, Projections are used for the which part, like what part of an entity you want to retrieve such as -

    criteria.setProjection(Projections.property("employeeName")); 

So the above criteria when executed, will fetch only the employeeName from the Employee table.

Restrictions are for the how/what part, like what subset of the data you want your criteria query to fetch. More specifically Restrictions fill the from and where part in the query.

    criteria.add(Restrictions.eq("emailId", emailId));
    criteria.setMaxResults(1);
    criteria.addOrder(Order.asc("employeeName"));
    
    Projection consists of distinct clauses and aggregate functions like max, sum
    Restriction has all conditions 
    Criteria can
 */
public class TestHQLProjections {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf= (SessionFactory) cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		
		try{
			Criteria c= s.createCriteria(Vehicle.class);
			c.setProjection(Projections.property("id"));
			
			List l=c.list();
			System.out.println(l);
			
			System.out.println("************************");
			Criteria c1= s.createCriteria(Vehicle.class);
			c1.setProjection(Projections.count("name"))
			.add(Restrictions.like("name", "Demo1"))	;
			
			List l1=c1.list();
			System.out.println(l1);
					
		}
		finally{
			s.close();
			sf.close();
		}
		
		
	}

}
