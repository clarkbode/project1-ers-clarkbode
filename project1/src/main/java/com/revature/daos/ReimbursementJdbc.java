package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementJdbc implements ReimbursementDao{

	@Override
	public int addReimbursement(User u, Reimbursement newReimb) { //QUESTION: In Blake's example, this returns int. Would it be better to return a reimbursement?
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO \"project-1\".ers_reimbursement(\r\n" + 
					"	reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
					);
			ps.setInt(1, newReimb.getReimb_id());
			ps.setDouble(2, newReimb.getReimb_amount());
			ps.setTimestamp(3, newReimb.getReimb_submitted());
			ps.setTimestamp(4, newReimb.getReimb_resolved());
			ps.setString(5, newReimb.getReimb_description());
			ps.setString(6, newReimb.getReimb_receipt());
			ps.setInt(7,  newReimb.getReimb_author());
			ps.setInt(8, newReimb.getReimb_status_id());
			ps.setInt(9, newReimb.getReimb_type_id());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				int id = rs.getInt("reimb_id");
				newReimb.setReimb_id(id);
				return id;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("DERP");
		}
		
		return 0;
	}

	@Override
	public Reimbursement resolveReimbursement(Reimbursement reimb, User u) {
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement(""); //UPDATE function
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("DERP");
		}
		
		return null;
	}

}
