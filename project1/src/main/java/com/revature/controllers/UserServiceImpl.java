package com.revature.controllers;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.model.User;

public class UserServiceImpl implements UserService{

	private UserDao ud = UserDao.currentImplementation;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ud.findAll();
	}

}
