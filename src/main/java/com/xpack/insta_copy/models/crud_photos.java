package com.xpack.insta_copy.models;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xpack.insta_copy.insta_copy_tables.Photos;

public class crud_photos {

	private Session session;
	private Transaction transaction;
	public void createPhoto(Photos photo) {
		try {
			//initializing the session and starting the transaction
			 this.session=new SessionFactoryBuilder().getSessionFactory().openSession();
			 this.transaction= this.session.beginTransaction();
			 
			 //adding the photo
			 this.session.save(photo);
			 this.transaction.commit();
			 
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.session.close();
		}
		
	}
	
	
	
}
