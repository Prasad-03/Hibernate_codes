package com.prasad.Demohib;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main(String[] args )
    {
        Gimmy gm=new Gimmy();
        gm.setId(2);
        gm.setName("Ruchika");
        gm.setSname("Ruch");
        
        Configuration cf=new Configuration().configure().addAnnotatedClass(Gimmy.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
        SessionFactory sf=cf.buildSessionFactory(sr);
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        s.save(gm);
        t.commit();
    }
}
