package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.model.Reimbursement;

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

}