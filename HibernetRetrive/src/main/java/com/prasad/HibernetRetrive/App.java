package com.prasad.HibernetRetrive;


import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.engine.transaction.spi.TransactionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	Retrive r=new Retrive();
    	
    	Configuration cf=new Configuration().configure().addAnnotatedClass(Retrive.class);
    	ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
    	SessionFactory sf=cf.buildSessionFactory(sr);
    	Session s=sf.openSession();
    	Transaction t=s.beginTransaction();
    	//s.save(r);
    	r= (Retrive)s.get(Retrive.class,2);
    	t.commit();
    	System.out.println(r);
    }
}
