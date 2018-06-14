package com.xpack.insta_copy.models;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryBuilder {
	private  Configuration configuration;
	private SessionFactory sessionFact;
	private ServiceRegistry serviceReg;
	
	private void buildSessionFactory() {
		try {
			this.configuration=new Configuration().configure("hibernate.cfg.xml");
			this.serviceReg=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			this.sessionFact=this.configuration.buildSessionFactory(serviceReg);
			
			
		}catch(Exception e) {
			System.out.println("couldn't generate the session Factory ");
			e.printStackTrace();
		}
		
	}
	
	public SessionFactory getSessionFactory() {
		this.buildSessionFactory();
		return sessionFact;
	}
	
}
