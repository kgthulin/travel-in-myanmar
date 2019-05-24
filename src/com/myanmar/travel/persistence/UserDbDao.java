package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myanmar.travel.vo.User;

public class UserDbDao implements UserDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	@Override
	public int getNumOfUsers(String email) {
		int numOfUsers = 0;
		String selectSQL = "SELECT COUNT(*) FROM User WHERE email=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			numOfUsers = rs.getInt(1);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return numOfUsers;
	}
	
	@Override
	public void create(User user) {
		String insertSQL = "INSERT INTO User(name,email,password) VALUES(?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public User getUser(String email) {
		User user = new User();
		String selectSQL = "SELECT id,name,email,password FROM User WHERE email=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<>();
		String selectSQL = "SELECT * FROM User WHERE name NOT IN('admin')";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				userList.add(new User(rs.getInt("id"), rs.getString("name"), 
										rs.getString("email"), 
										rs.getString("password")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return userList;
	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM User WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
