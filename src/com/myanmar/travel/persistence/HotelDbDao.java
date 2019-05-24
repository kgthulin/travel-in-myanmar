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
import com.myanmar.travel.vo.Hotel;

public class HotelDbDao implements HotelDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	private LocationService locationService = new LocationDaoService();
	
	@Override
	public void create(Hotel hotel) {
		String insertSQL = "INSERT INTO Hotel(name,price,rating,phone,location_id) VALUES(?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, hotel.getName());
			ps.setInt(2, hotel.getPrice());
			ps.setDouble(3, hotel.getRating());
			ps.setString(4, hotel.getPhone());
			ps.setInt(5, hotel.getLocation().getLocation_id());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Hotel> getAllHotel() {
		List<Hotel> hotelList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Hotel";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				hotelList.add(new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getInt("price"), 
										rs.getDouble("rating"), rs.getString("phone"), 
										locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return hotelList;
	}

	@Override
	public Hotel getHotel(int id) {
		Hotel hotel = new Hotel();
		String selectSQL = "SELECT name,price,rating,phone,location_id FROM Hotel WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hotel.setHotel_id(id);
				hotel.setName(rs.getString("name"));
				hotel.setPrice(rs.getInt("price"));
				hotel.setRating(rs.getDouble("rating"));
				hotel.setPhone(rs.getString("phone"));
				hotel.setLocation(locationService.getLocation(rs.getInt("location_id")));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return hotel;
	}

	@Override
	public void update(int id, Hotel hotel) {
		String updateSQL = "UPDATE Hotel SET name=?,price=?,rating=?,phone=? WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setString(1, hotel.getName());
			ps.setInt(2, hotel.getPrice());
			ps.setDouble(3, hotel.getRating());
			ps.setString(4, hotel.getPhone());
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM Hotel WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Hotel> getAllHotelByLocation(int loc_id) {
		List<Hotel> hotelList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Hotel WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, loc_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hotelList.add(new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getInt("price"), 
										rs.getDouble("rating"), rs.getString("phone"), 
										locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return hotelList;
	}

	@Override
	public void deleteByLocation(int locationId) {
		String deleteSQL = "DELETE FROM Hotel WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, locationId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
