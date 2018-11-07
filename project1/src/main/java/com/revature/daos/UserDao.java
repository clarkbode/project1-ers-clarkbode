package com.revature.daos;

import com.revature.model.User;

public interface UserDao {
	public static final  UserDao currentImplementation = new UserJdbc();
	
	User findById(int id);

}
