package com.prasad.HibernateHQL;
import java.util.List;
import java.util.Random;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class App 
{
    public static void main( String[] args )
    {
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(sr);
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        /*
         * This code to fetch all the data from table, here student is not an entity we also use where clause to fetch data
        Query q=s.createQuery("from Student");
        List<Student> sd=q.list();
        for(Student x:sd)
        {
        	System.out.println(x);
        }
        */
        
        
        /*
         * This is to fetch only single record using uniqueResult()
        Query q=s.createQuery("from Student where roll=3");
        Student sd=(Student)q.uniqueResult();
        System.out.println(sd);
        */
        
        
        Query q=s.createQuery("select roll,name,marks from Student");
        List<Object[]> sl=(List<Object[]>)q.list();
        for(Object[] sd:sl)
        {
        	System.out.println(sd[0]+"  "+ sd[1]+" " + sd[2]);
        }
        
        t.commit();
    }
}
