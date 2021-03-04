package com.prasad.HibernateSQL;



import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;



public class App 
{
    public static void main( String[] args )
    {
        Configuration con=new Configuration().configure().addAnnotatedClass(Ruchika.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(sr);
        Session s=sf.openSession();
        s.beginTransaction();

 // This code add data to table with random string
//        for(int j=1;j<40;j++)
//        {
//        	Random r=new Random();
//            int llimit=97;
//            int rlimit=122;
//            int slen=4;
//            StringBuilder sb=new StringBuilder(slen);
//            for(int i=1;i<slen;i++)
//            {
//            	int total=llimit+(int)(r.nextFloat()*(rlimit-llimit+1));
//            	sb.append((char)total);
//            }
//            String rs=sb.toString();
//        	Ruchika rr=new Ruchika();
//        	rr.setId(j);
//        	rr.setName(rs);
//        	s.save(rr);
//        	
//        }
        /*
         * This code retrive data using sql query not using hql
        SQLQuery sq=s.createSQLQuery("select * from ruchi ");
        sq.addEntity(Ruchika.class);
        List<Ruchika> l= sq.list();
        for(Ruchika rk:l)
        {
        	System.out.println(rk);
        }
        */
        
        /*
         * This code convert your data into map 
         
        SQLQuery sq=s.createSQLQuery("select id,name from ruchi where id>20");
        sq.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List l= sq.list();
        for(Object rk:l)
        {
        	Map m=(Map)rk;
        	System.out.println(m.get("id")+" :  "+m.get("name"));
        }
        */
        s.getTransaction().commit();

        
        
    }
}
