package com.xpack.insta_copy.models;

import java.util.ArrayList;
import java.util.List;

import com.xpack.insta_copy.insta_copy_tables.Users;




public class MainApp {
	
	//saving all the users in the database
	public void saveUsers(List<Users> users) {
		Crud_users userOps=new Crud_users();
		for(Users u:users) {
			userOps.createUser(u);
		}
	}

	public static void main(String[] args) {
		Users user1=new Users("xpack");
		Users user2=new Users("billy");
		Users user3=new Users("nate");
		Users user4=new Users("elliote");
		
		List<Users> users =new ArrayList<Users>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		new MainApp().saveUsers(users);
		
		
	}

}
