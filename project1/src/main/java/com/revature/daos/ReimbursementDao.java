package com.revature.daos;

import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface ReimbursementDao {
	public static final  ReimbursementDao currentImplementation = new ReimbursementJdbc();
	
	int addReimbursement(Reimbursement newReimb);
	
	void resolveReimbursement(int reimbId, int userId, int newStatusId);
	
	List<Reimbursement> findAll();
	List<Reimbursement> findAllByStatus(int status);  

}
