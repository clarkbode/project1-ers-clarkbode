package com.revature.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.util.ResponseMapper;

public class UserController {
	private Logger log = Logger.getRootLogger();
	private UserService us = UserService.currentImplementation;
	private ObjectMapper om = new ObjectMapper();

	void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String method = req.getMethod();
		log.trace("reqiest made to reimbursement controller with method: " + req.getMethod());
		switch (method) {
		case "GET":
			processGet(req, resp);
			break;
		case "POST":
			processPost(req, resp);
			break;
		case "OPTIONS":
			return;
		default:
			resp.setStatus(404);
			break;
		}
	}

	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	// ServletException, IOException

	private void processGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		String uri = req.getRequestURI();
		String context = "project1";
		uri = uri.substring(context.length() + 2, uri.length());
		log.debug(uri);
		String[] uriArray = uri.split("/");
		System.out.println(Arrays.toString(uriArray));

		if (uriArray.length == 1) {
			System.out.println("Retrieving all Reimbursements");
			List<User> reimbs = us.findAll();
			ResponseMapper.convertAndAttach(reimbs, resp);
			return;

		} else if (uriArray.length == 2) {
			int id = Integer.parseInt(uriArray[1]);
			log.info("Retrieving user with id: " + id);
			 User u = us.findById(id);
			 ResponseMapper.convertAndAttach(u, resp);
			 return;
		}
//		} else if (uriArray.length == 3 && uriArray[1].equals("status")) {
//			// String status = uriArray[2];
//			int status = Integer.parseInt(uriArray[2]); // if there's a way to make this a string easily, I may want to
//														// change it back. Ask blake.
//			log.info("finding all champions with role: " + status);
//			List<User> reimbs = us.findAllByStatus(status);
//			ResponseMapper.convertAndAttach(status, resp);
//			return;
//		}
	}
	// processPost?

	private void processPost(HttpServletRequest req, HttpServletResponse resp)
			throws JsonParseException, JsonMappingException, IOException {
		String uri = req.getRequestURI();
		String context = "project1";
		uri = uri.substring(context.length() + 2, uri.length());
		if (!"users".equals(uri)) {
			log.debug("could not recognize request with uri: " + uri);
			resp.setStatus(404);
			return;
		} else {
			String role = (String) req.getSession().getAttribute("role");
			if (!"ADMIN".equals(role)) {
				resp.setStatus(403);
				return;
			} else {
				log.info("saving new user");
				User u = om.readValue(req.getReader(), User.class);
				// rs.AddReimbursement(r); (NEEDS TO BE IMPLEMENTED
				resp.getWriter().write("" + u.getUser_id());
				resp.setStatus(201);
				return;
			}
		}
	}
}
