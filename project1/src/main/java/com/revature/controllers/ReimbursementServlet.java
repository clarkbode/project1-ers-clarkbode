package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;

public class ReimbursementServlet extends HttpServlet{

	private ReimbursementService rs = ReimbursementService.currentImplementation;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Initializing...");
		
		//Will be needed later for the front-end, but for now it's incomplete
//		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//			res.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//			res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//			res.addHeader("Access-Control-Allow-Headers",
//					"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
//			res.addHeader("Access-Control-Allow-Credentials", "true");
//			res.setContentType("application/json");
//			
//			System.out.println(req.getRequestURL());
//			super.service(req, res);
//		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Getting requests...");
		
		List<Reimbursement> l = rs.findAll();
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(l);
		resp.getWriter().write(json);
	}
}
