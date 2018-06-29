package com.xpack.insta_copy.models;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xpack.insta_copy.insta_copy_tables.Users;

public class Crud_users {

	private Session session;
	private Transaction transaction;
	public void createUser(Users user) {
		try {
			//initializing the session and starting the transaction
			 this.session=new SessionFactoryBuilder().getSessionFactory().openSession();
			 this.transaction= this.session.beginTransaction();
			 
			 //adding the user
			 this.session.save(user);
			 this.transaction.commit();
			 
			
			
		}catch(Exception e) {
			System.out.println("can't create the session");
			e.printStackTrace();
		}finally {
			this.session.close();
		}
		
	}
	//update the user username
	public void updateUserUsername(int userId,String username) {
		try {
			this.session =new SessionFactoryBuilder().getSessionFactory().openSession();
			this.transaction=this.session.beginTransaction();
			Query query = session.createQuery("from Users where id="+userId);
			Users user=(Users)query.uniqueResult();
			
			user.setUsername(username);
			session.update(user);
			this.transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			this.session.close();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			this.session =new SessionFactoryBuilder().getSessionFactory().openSession();
			this.transaction=this.session.beginTransaction();
			Query query = session.createQuery("from Users where id="+userId);
			Users user=(Users)query.uniqueResult();
			session.delete(user);
			this.transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			this.session.close();
		}
		
	}
	
	
	
	
	
}
