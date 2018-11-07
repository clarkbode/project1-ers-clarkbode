package com.revature.daos;

import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface UserDao {
	public static final  UserDao currentImplementation = new UserJdbc();
	
	User findById(int id);
	
	Reimbursement addReimbursement(User u);
	
	Reimbursement resolveReimbursement(Reimbursement reimb);

}
