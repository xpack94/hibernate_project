package com.xpack.hibernate;


import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
    	String [] t= {"test","haha"};
    	
//    	Name names = new Name();
//    	names.setFirst_name("xpack");
//    	names.setLast_name("xp");
//    	names.setMiddle_name("dj");
//        Students xpack = new Students();
//        xpack.setId(2);
//        xpack.setNames(names);
//        Laptop l1=new Laptop();
//        l1.setLaptop_name("dell");
//        Laptop l2=new Laptop();
//        l2.setLaptop_name("tochiba");
//        
      //  l1.setStudent(xpack);

        
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry service = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(service);
       
        Session session = sf.openSession();
        
        session.beginTransaction();
//        session.save(xpack);
//        session.save(l1);
//        session.save(l2);
//      
        Query query = session.createQuery("select s from Students s inner join s.laptops");
        List<Students> students = query.list();
        
        for(Students s:students) {
        	System.out.println(s);
        	
        	
        }
        
        
        
        session.getTransaction().commit();
        session.close();
       
        
       // System.out.println(s);
        
    }
}
