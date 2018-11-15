package com.revature.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.revature.model.TimeTest;

public class DispatcherServlet extends HttpServlet {
	private Logger log = Logger.getRootLogger();
	private UserController uc = new UserController();
	private ReimbursementController rc = new ReimbursementController();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
		
		String uri = req.getRequestURI();
		String context = "project1";
		uri = uri.substring(context.length() + 2, uri.length());
		log.debug("request made with uri: " + uri);
		if (uri.startsWith("users")) {
			uc.process(req, resp);
		} else if (uri.startsWith("reimbursements")) {
			rc.process(req, resp);
		} else if (uri.startsWith("test")) {
			resp.getWriter().write("test");
			return;
		} else {
			resp.setStatus(404);
		}
	}

}
