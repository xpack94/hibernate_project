package com.xpack.insta_copy.models;

import java.util.ArrayList;
import java.util.List;

import com.xpack.insta_copy.insta_copy_tables.Photos;
import com.xpack.insta_copy.insta_copy_tables.Users;




public class MainApp {
	
	public void createPhotos() {
		List<Users> users = new Crud_users().getUsers();
		List<Photos>photos=new ArrayList<Photos>();
		for (Users user:users) {
			photos.add(new Photos("/photo/user/"+user.getUsername(),user));
			
		}
		this.saveElements(photos);
	}
	
	public void createUsers() {
		Users user1=new Users("xpack");
		Users user2=new Users("billy");
		Users user3=new Users("nate");
		Users user4=new Users("elliote");
		
		List<Users> users =new ArrayList<Users>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		this.saveUsers(users);
	}
	
	
	//saving all the users in the database
	public void saveUsers(List<Users> users) {
		Crud_users userOps=new Crud_users();
		for(Users u:users) {
			userOps.createUser(u);
		}
	}
	
	//saving elements  in the database
	//these elements can be of type Users of Photos
		public <T> void saveElements(List<T> elements) {
			for(T elm:elements) {
				if(elm.getClass().isInstance(Users.class)) {
					new Crud_users().createUser((Users)elm);
				}else {
					new crud_photos().createPhoto((Photos)elm);
				}
			}
		}
	
	public static void main(String[] args) {
		
		//new MainApp().createUsers();
		//updating a user username
		//new Crud_users().updateUserUsername(1, "xpac");
		
		//deleting a user	
		//new Crud_users().deleteUser(3);
		
		//adding photos
		new MainApp().createPhotos();
		
	}

}
