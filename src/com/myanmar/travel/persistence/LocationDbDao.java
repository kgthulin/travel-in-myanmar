package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myanmar.travel.vo.Location;

public class LocationDbDao implements LocationDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	@Override
	public void create(Location location) {
		String insertSQL = "INSERT INTO Location(name,mile) VALUES(?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, location.getName());
			ps.setDouble(2, location.getMile());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> locationList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Location";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				locationList.add(new Location(rs.getInt("location_id"), rs.getString("name"), 
						rs.getDouble("mile")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return locationList;
	}

	@Override
	public Location getLocation(int id) {
		Location location = new Location();
		String selectSQL = "SELECT name,mile FROM Location WHERE location_id=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			location.setLocation_id(id);
			location.setName(rs.getString("name"));
			location.setMile(rs.getDouble("mile"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return location;
	}

	@Override
	public void update(int id, Location location) {
		String updateSQL = "UPDATE Location SET name=?,mile=? WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setString(1, location.getName());
			ps.setDouble(2, location.getMile());
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM Location WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
