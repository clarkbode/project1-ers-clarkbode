package com.revature.daos;

import java.util.List;

//import com.revature.model.AppUser;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface UserDao {
	public static final  UserDao currentImplementation = new UserJdbc();
	
	User findById(int id);

	List<User> findAll();
	


}
