package com.prasad.HibernateCache;

import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.*;
public class App 
{
    public static void main( String[] args )
    {
    	Demo d=null;
       Configuration con=new Configuration().configure().addAnnotatedClass(Demo.class);
       ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf=con.buildSessionFactory(sr);
       Session s=sf.openSession();
       s.beginTransaction();
       d=(Demo) s.get(Demo.class, 1);// SINCE WE FIRE A QUERY SECND TIME IT NOT GOES TO DB IT FETCH FROM LEVEL 1 CACHE N ALSO CHECK IN LEVEL2 IF NOT THEN IT GOES TO DB
       System.out.println(d);
       s.getTransaction().commit();
       s.close();
       
       Session s2=sf.openSession();
       s2.beginTransaction();
       d=(Demo) s2.get(Demo.class, 1); //when we try for cache 2 it is not worked bc the jar file not contain regionfactory class
       System.out.println(d);
       s2.getTransaction().commit();
       s2.close();
    }
}

		