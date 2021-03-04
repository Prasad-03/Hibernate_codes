package com.prasad.HibernateRelaationship;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Laptop l=new Laptop();
         l.setId(104);
         l.setLname("Bababr");
//         
         
	       Student s=new Student();
	       s.setRoll(4);
	       s.setName("Prasad");
	       s.setMarks(50);
	       s.getLapy().add(l);
       l.getStud().add(s);
      
       
       Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf=con.buildSessionFactory(sr);
       Session ss=sf.openSession();
       Transaction t=ss.beginTransaction();
       ss.save(s);
       ss.save(l);
      
       
       t.commit();
       
    }
}
