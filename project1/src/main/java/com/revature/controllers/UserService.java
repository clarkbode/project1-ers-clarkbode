package com.revature.controllers;

import java.util.List;

import com.revature.model.User;

public interface UserService {


	UserService currentImplementation = new UserServiceImpl();

	List<User> findAll();
}
