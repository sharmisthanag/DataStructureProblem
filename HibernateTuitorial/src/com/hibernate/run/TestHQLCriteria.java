package com.hibernate.run;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;
import com.hibernate.model.FourWheeler;
import com.hibernate.model.Vehicle;

public class TestHQLCriteria {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf= (SessionFactory) cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		
		try{
			Criteria c=s.createCriteria(Vehicle.class);
			List vehlist=c.list();
			System.out.println("vehlist=>"+vehlist);
			System.out.println("*********************************************");
			
			Criteria c1=s.createCriteria(Vehicle.class)
					.add(Restrictions.gt("id", 2))
					.add(Restrictions.like("name", "Demo%"));	
			
			List vehlist1=c1.list();
			System.out.println("vehlist1=>"+vehlist1);
			System.out.println("*********************************************");
			
			//If OR Criteria is needed
			Criteria c2=s.createCriteria(Vehicle.class);
			c2.add(Restrictions.or(Restrictions.between("id", 2,5),Restrictions.between("id", 10,15)));
					
			List vehlist2=c2.list();
			System.out.println("vehlist2=>"+vehlist2);
			System.out.println("*********************************************");
			
			Criteria c3=s.createCriteria(Vehicle.class);
			c3.add(Restrictions.between("id", 1, 5));
			c3.addOrder(Order.asc("name"));
			List vehlist3=c3.list();
			System.out.println("vehlist3=>"+vehlist3);
			
			System.out.println("*********************************************");
			
			Criteria c4=s.createCriteria(Vehicle.class);c4.add(Restrictions.eq("id", 30));
			c4.setFetchMode("emp", FetchMode.EAGER);
			
			
			List vehlist4=c4.list();
			System.out.println("vehlist4=>"+vehlist4);
			
			
		}
		finally{
			s.close();
			sf.close();
		}
		
		
	}

}
