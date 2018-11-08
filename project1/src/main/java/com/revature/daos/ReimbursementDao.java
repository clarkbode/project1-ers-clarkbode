package com.revature.daos;

import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface ReimbursementDao {
	public static final  ReimbursementDao currentImplementation = new ReimbursementJdbc();
	
	int addReimbursement(User u, Reimbursement newReimb);
	
	Reimbursement resolveReimbursement(Reimbursement reimb, User u);

}
