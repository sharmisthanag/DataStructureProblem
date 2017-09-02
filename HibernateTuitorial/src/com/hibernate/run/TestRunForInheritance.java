package com.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.FourWheeler;
import com.hibernate.model.TwoWheeler;
import com.hibernate.model.Vehicle;

public class TestRunForInheritance {

	public static Session s,s1,s2,s3;
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf= (SessionFactory) cfg.buildSessionFactory(sr);
		s= sf.openSession();s.beginTransaction();
		try{
			
			Vehicle v=new Vehicle("Veh20");
			FourWheeler fw = new FourWheeler();fw.setSteeringWheel("Veh21 Steering");fw.setName("Veh21");
			TwoWheeler tw = new TwoWheeler();tw.setSteeringHandle("Veh22 Steering");tw.setName("Veh22");
			s.saveOrUpdate(v);
			s.saveOrUpdate(fw);
			s.saveOrUpdate(tw);
			
			v.setName("Demo");//SInce it is persistent object so it will updated
			
			s.getTransaction().commit();
			v.setName("Demo1");//This does NOT get updated as transaction is already committed 
			s.close();
			
			System.out.println("s closed****************************************"+v.getId());
			
			
			//V is detached in this point of time .**Detached to Persistent
			s1= sf.openSession();s1.beginTransaction();
			/*When v is detached then only if you fetch same object with current session it will work .
			 * But if any write operation is performed is performed after that on the old object then below exception will be thrown :  
			 * org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session 
			 * 
			 */
			//Vehicle v1=(Vehicle)s.get(Vehicle.class, v.getId());
			//if(v1==v)System.out.println("v1==v is true");//since v is not yet Persistent ,so it throws Exception org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session
			
			//To make v as Persistent update v through session;
			//s.save(v);//Since v is detached,if we call save(v),new row is created
			s1.update(v);
			
			Vehicle v2=(Vehicle)s1.get(Vehicle.class, 1);
			if(v2==v)System.out.println("v2==v is true");//once v is saved it is again in state Persistent so v2==v is equal
					
			System.out.println(sf.getStatistics().getEntityFetchCount());           //Prints 1
			System.out.println(sf.getStatistics().getSecondLevelCacheHitCount());   //Prints 0
			 
			s1.getTransaction().commit();
			s1.close();
			System.out.println("s1 closed****************************************");
			
			s2= sf.openSession();
			Vehicle v3=(Vehicle)s2.get(Vehicle.class, 1);
			if(v3==v)System.out.println("v3==v is true");//once v is saved it is again in state Persistent so v2==v is equal
			System.out.println(sf.getStatistics().getEntityFetchCount());           //Prints 1
			System.out.println(sf.getStatistics().getSecondLevelCacheHitCount());
			s2.close();
			System.out.println("s2 closed****************************************");
		}
		finally{
			sf.close();
		}
		
	}

	
}
