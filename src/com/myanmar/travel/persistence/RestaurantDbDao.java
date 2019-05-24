package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myanmar.travel.service.LocationDaoService;
import com.myanmar.travel.service.LocationService;
import com.myanmar.travel.vo.Restaurant;

public class RestaurantDbDao implements RestaurantDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	private LocationService locationService = new LocationDaoService();

	@Override
	public void create(Restaurant restaurant) {
		String insertSQL = "INSERT INTO Restaurant(name,price,phone,location_id) VALUES(?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, restaurant.getName());
			ps.setInt(2, restaurant.getPrice());
			ps.setString(3, restaurant.getPhone());
			ps.setInt(4, restaurant.getLocation().getLocation_id());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restaurantList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Restaurant";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				restaurantList.add(new Restaurant(rs.getInt("restaurant_id"), rs.getString("name"), rs.getInt("price"), 
													rs.getString("phone"), locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant restaurant = new Restaurant();
		String selectSQL = "SELECT name,price,phone,location_id FROM Restaurant WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				restaurant.setRestaurant_id(id);
				restaurant.setName(rs.getString("name"));
				restaurant.setPrice(rs.getInt("price"));
				restaurant.setPhone(rs.getString("phone"));
				restaurant.setLocation(locationService.getLocation(rs.getInt("location_id")));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return restaurant;
	}

	@Override
	public void update(int id, Restaurant restaurant) {
		String updateSQL = "UPDATE Restaurant SET name=?,price=?,phone=? WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setString(1, restaurant.getName());
			ps.setInt(2, restaurant.getPrice());
			ps.setString(3, restaurant.getPhone());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM Restaurant WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Restaurant> getAllRestaurantByLocation(int loc_id) {
		List<Restaurant> restaurantList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Restaurant WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, loc_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				restaurantList.add(new Restaurant(rs.getInt("restaurant_id"), rs.getString("name"), rs.getInt("price"), 
						rs.getString("phone"), locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return restaurantList;
	}

	@Override
	public void deleteByLocation(int locationId) {
		String deleteSQL = "DELETE FROM Restaurant WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, locationId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
