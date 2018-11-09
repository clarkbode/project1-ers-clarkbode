package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserJdbc implements UserDao{
	
	private User extractFromResultSet(ResultSet rs) throws SQLException {
		return new User(
				rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
				rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
				rs.getInt("user_role_id")
				);
	}
	
	private Logger log = Logger.getRootLogger(); //for some reason getRootLogger() doesn't exist

	@Override
	public User findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.debug("finding user with the id " + id);
			Statement s = conn.createStatement(); //should use prepared statement instead
			ResultSet rs = s.executeQuery( //SQL query goes here. THIS IS BLAKE'S QUERY FROM THE DEMO, NEED TO REPLACE WITH MY OWN
						// my Query should create a join of ers_users and ers_reimbursements on the ers_users_id column
					"SELECT user_id, fruit_id, u.name as user_name, f.name as fruit_name, " + 
					" 	age, color, flavorrating FROM users u " + 
					"INNER JOIN users_fruit uf " +
					"ON u.id = uf.user_id " +
					"INNER JOIN fruit f " + 
					"ON uf.fruit_id = f.id " +
					"WHERE u.id = " + id);
			
			if(rs.next()) {
				log.trace("user found with id " + id + " attempting to extract result set");
				User u = new User (rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), 
						rs.getInt("user_role_id"));
				
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users"); //SQL statement to find all the reimbursements
			ResultSet rs = ps.executeQuery();
			
			//loop to populate a list with the items found in the ps.
			List<User> users = new ArrayList<>();
			while (rs.next()) {
				users.add(extractFromResultSet(rs));
			}
			return users;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINDALL USERS");
		}
		return null;
	}



	}


