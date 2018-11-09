package com.revature.controllers;

import java.util.List;
import com.revature.model.*;

public interface ReimbursementService {

	ReimbursementService currentImplementation = new ReimbursementServiceImpl();

	List<Reimbursement> findAll();
}
