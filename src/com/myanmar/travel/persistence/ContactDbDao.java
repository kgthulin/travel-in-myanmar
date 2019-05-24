package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myanmar.travel.vo.Contact;

public class ContactDbDao implements ContactDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	@Override
	public void create(Contact contact) {
		String insertSQL = "INSERT INTO Contact(name,phone,email,message) VALUES(?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhone());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getMessage());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
