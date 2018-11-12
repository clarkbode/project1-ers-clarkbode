package com.revature.services;

import java.util.List;
import com.revature.model.*;

public interface ReimbursementService {

	ReimbursementService currentImplementation = new ReimbursementServiceImpl();

	List<Reimbursement> findAll();
	
	List<Reimbursement> findAllByStatus(int status);
	
	int addReimbursement(User u, Reimbursement newReimb);
	
	void resolveReimbursement(int reimbId, int userId, int newStatusId);
}
