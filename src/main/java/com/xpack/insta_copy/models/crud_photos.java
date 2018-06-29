package com.xpack.insta_copy.models;

import org.hibernate.Query;
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
	
	public void updatePhotoUrl(int photoId,String photoUrl) {
		try {
			//initializing the session and starting the transaction
			 this.session=new SessionFactoryBuilder().getSessionFactory().openSession();
			 this.transaction= this.session.beginTransaction();
			 
			 Query query =this.session.createQuery("from Photos where id="+photoId);
			 Photos photo=(Photos) query.uniqueResult();
			 photo.setImage_url(photoUrl);
			 session.update(photo);
			 transaction.commit();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.session.close();
		}
		
	}
	
	
	public void deletePhoto(int photoId) {
		try {
			//initializing the session and starting the transaction
			 this.session=new SessionFactoryBuilder().getSessionFactory().openSession();
			 this.transaction= this.session.beginTransaction();
			 
			 Query query =this.session.createQuery("from Photos where id="+photoId);
			 Photos photo=(Photos) query.uniqueResult();
			 session.delete(photo);
			 transaction.commit();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.session.close();
		}
		
	}
	
	
}
