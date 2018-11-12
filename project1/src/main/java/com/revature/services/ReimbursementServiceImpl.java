package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementServiceImpl implements ReimbursementService{
	
private ReimbursementDao rd = ReimbursementDao.currentImplementation;
	
	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return rd.findAll();
	}


	@Override
	public List<Reimbursement> findAllByStatus(int status) {
		// TODO Auto-generated method stub
		return rd.findAllByStatus(status);
	}


	@Override
	public int addReimbursement(User u, Reimbursement newReimb) {
		// TODO Auto-generated method stub
		return rd.addReimbursement(u, newReimb);
	}


	@Override
	public void resolveReimbursement(int reimbId, int userId, int newStatusId) {
		// TODO Auto-generated method stub
		rd.resolveReimbursement(reimbId, userId, newStatusId);
		//return; No return because this is a void
	}



}