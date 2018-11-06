package com.revature.daos;

public interface UserDao {
	public static final  UserDao currentImplementation = new UserJdbc();
	

}
