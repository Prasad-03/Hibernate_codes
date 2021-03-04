package com.prasad.HibernateEmbed;

import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.*;
public class App 
{
    public static void main( String[] args )
    {
    	Embed ed=new Embed();
    	ed.setFname("Prasad");
    	ed.setLname("Babar");
    	
        Demo d=new Demo();
        d.setId(1);
        d.setName(ed);
        d.setNumber("9820");
        
        Configuration cf=new Configuration().configure().addAnnotatedClass(Demo.class);	
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
        SessionFactory sf=cf.buildSessionFactory(sr);
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        s.save(d);
        t.commit();
        
    }
}
