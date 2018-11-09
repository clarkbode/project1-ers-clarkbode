package com.revature.launchers;


import com.revature.daos.ReimbursementDao;
import com.revature.daos.UserDao;

public class Launcher {
	public static void main(String[] args) {
		UserDao ud = UserDao.currentImplementation;
		ReimbursementDao rd = ReimbursementDao.currentImplementation;
////		System.out.println(ud.findById(10));
//
////		System.out.println(fd.findByName("sdlkfjds' OR 1=1 --"));
//
////		System.out.println(fd.save(new Fruit(0, "Papaya", "orangeish", 3)));
//
//		System.out.println(rd.findByName("papaya"));
		System.out.println("TESTING!");
		
		//System.out.println(rd.findAll());
		System.out.println(ud.findAll());
	}
}
