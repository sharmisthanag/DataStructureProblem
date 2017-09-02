package com.hibernate.run;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Vehicle;

public class TestHQLQueries {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf= (SessionFactory) cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		
		try{
			
			Query q=s.createQuery("from vehicle");//if entity name is incorrect[wrong OR provide the Table name in db EMP_VEHICLE] then  it throws QuerySyntaxException
			List<Vehicle> l=q.list();
			System.out.println(l.size());
			System.out.println("*****************************");
			Query q1=s.createQuery("from vehicle");
			q1.setFirstResult(5);
			q1.setMaxResults(10);
			List<Vehicle> l1=q1.list();
			System.out.println(l1.size()+"\n"+l1);
			System.out.println("*****************************");
			
			Query q11=s.createQuery("select name from vehicle");
			List<String> vehNames=q11.list();
			System.out.println(vehNames);
			System.out.println("*****************************");
			
			Query q111=s.createQuery("select new map(name,id) from vehicle");
			List<Map<String,String>> m=q111.list();
			System.out.println(m.get(0));
			
			System.out.println("*****************************");
			Query q1111=s.createQuery("select max(id) from vehicle");
			List m1=q1111.list();
			System.out.println(m1);
			System.out.println("*****************************");
			//Parameter Binding
			
			Query q2=s.createQuery("from vehicle where id>? and name like ?");//WARNING: WARN: [DEPRECATION] Encountered positional parameter near line 1, column 59 in HQL: [from com.hibernate.model.Vehicle where id>? and name like ?].  Positional parameter are considered deprecated; use named parameters or JPA-style positional parameters instead.
			q2.setInteger(0, 2);q2.setString(1, "D%");
			List pb=q2.list();
			System.out.println(pb);
			System.out.println("*****************************");
			
			Query q21=s.createQuery("from vehicle where id> :id and name like :name");
			q21.setInteger("id", 2);q21.setString("name", "D%");
			List pb1=q21.list();
			System.out.println(pb1);
			System.out.println("*****************************");
			
			//Named Query
			
			Query q3=s.getNamedQuery("getAllEmployee");
			List<Vehicle> p3=q3.list();
			System.out.println("p3=>"+p3);
			System.out.println("*****************************");
			
			Query q4=s.getNamedQuery("getAllEmployee_native");
			List<Vehicle> p4=q4.list();
			System.out.println("p4=>"+p4);
			
		}
		finally{
			s.close();
			sf.close();
		}
		
		
	}

}
