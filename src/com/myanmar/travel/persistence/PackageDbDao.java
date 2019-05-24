package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myanmar.travel.service.HotelDaoService;
import com.myanmar.travel.service.HotelService;
import com.myanmar.travel.service.LocationDaoService;
import com.myanmar.travel.service.LocationService;
import com.myanmar.travel.service.RestaurantDaoService;
import com.myanmar.travel.service.RestaurantService;
import com.myanmar.travel.service.TicketDaoService;
import com.myanmar.travel.service.TicketService;
import com.myanmar.travel.vo.TravelPackage;

public class PackageDbDao implements PackageDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}
	
	private LocationService locationService = new LocationDaoService();
	private HotelService hotelService = new HotelDaoService();
	private RestaurantService restaurantService = new RestaurantDaoService();
	private TicketService ticketService = new TicketDaoService();
	
	@Override
	public void create(TravelPackage travelPackage) {
		String insertSQL = "INSERT INTO Package(location_id,hotel_id,restaurant_id,ticket_id,price,number_of_day,quantity,flag) VALUES(?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setInt(1, travelPackage.getLocation().getLocation_id());
			ps.setInt(2, travelPackage.getHotel().getHotel_id());
			ps.setInt(3, travelPackage.getRestaurant().getRestaurant_id());
			ps.setInt(4, travelPackage.getTicket().getTicket_id());
			ps.setInt(5, travelPackage.getPrice());
			ps.setInt(6, travelPackage.getNumber_of_day());
			ps.setInt(7, travelPackage.getQuantity());
			ps.setInt(8, 0);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<TravelPackage> getAllPackage() {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Package";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				packageList.add(new TravelPackage(rs.getInt("id"), locationService.getLocation(rs.getInt("location_id")), 
													hotelService.getHotel(rs.getInt("hotel_id")), 
													restaurantService.getRestaurant(rs.getInt("restaurant_id")),
													ticketService.getTicket(rs.getInt("ticket_id")), 
													rs.getInt("price"), rs.getInt("number_of_day"), rs.getInt("quantity")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}

	@Override
	public List<TravelPackage> getPackageByLocAndPrice(int locationId, int price) {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Package WHERE location_id=? AND price<=? ORDER BY price";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, locationId);
			ps.setInt(2, price);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				packageList.add(new TravelPackage(rs.getInt("id"), locationService.getLocation(rs.getInt("location_id")), 
													hotelService.getHotel(rs.getInt("hotel_id")), 
													restaurantService.getRestaurant(rs.getInt("restaurant_id")),
													ticketService.getTicket(rs.getInt("ticket_id")), 
													rs.getInt("price"), rs.getInt("number_of_day"), rs.getInt("quantity")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}
	
	@Override
	public List<TravelPackage> getPackageByHotel(int hotelId) {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Package WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, hotelId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				packageList.add(new TravelPackage(rs.getInt("id"), locationService.getLocation(rs.getInt("location_id")), 
													hotelService.getHotel(rs.getInt("hotel_id")), 
													restaurantService.getRestaurant(rs.getInt("restaurant_id")),
													ticketService.getTicket(rs.getInt("ticket_id")), 
													rs.getInt("price"), rs.getInt("number_of_day"), rs.getInt("quantity")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}
	
	@Override
	public List<TravelPackage> getPackageByRestaurant(int resId) {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Package WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, resId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				packageList.add(new TravelPackage(rs.getInt("id"), locationService.getLocation(rs.getInt("location_id")), 
													hotelService.getHotel(rs.getInt("hotel_id")), 
													restaurantService.getRestaurant(rs.getInt("restaurant_id")),
													ticketService.getTicket(rs.getInt("ticket_id")), 
													rs.getInt("price"), rs.getInt("number_of_day"), rs.getInt("quantity")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}
	
	@Override
	public List<TravelPackage> getPackageByTicket(int ticketId) {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Package WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, ticketId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				packageList.add(new TravelPackage(rs.getInt("id"), locationService.getLocation(rs.getInt("location_id")), 
													hotelService.getHotel(rs.getInt("hotel_id")), 
													restaurantService.getRestaurant(rs.getInt("restaurant_id")),
													ticketService.getTicket(rs.getInt("ticket_id")), 
													rs.getInt("price"), rs.getInt("number_of_day"), rs.getInt("quantity")));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}

	@Override
	public void insertBuyPackage(int userId, int packageId) {
		String insertSQL = "INSERT INTO Buy_Package(user_id,package_id) VALUES(?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setInt(1, userId);
			ps.setInt(2, packageId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public TravelPackage getPackage(int id) {
		TravelPackage travelPackage = new TravelPackage();
		String selectSQL = "SELECT * FROM Package WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				travelPackage.setId(id);
				travelPackage.setLocation(locationService.getLocation(rs.getInt("location_id")));
				travelPackage.setHotel(hotelService.getHotel(rs.getInt("hotel_id")));
				travelPackage.setRestaurant(restaurantService.getRestaurant(rs.getInt("restaurant_id")));
				travelPackage.setTicket(ticketService.getTicket(rs.getInt("ticket_id")));
				travelPackage.setPrice(rs.getInt("price"));
				travelPackage.setNumber_of_day(rs.getInt("number_of_day"));
				travelPackage.setQuantity(rs.getInt("quantity"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return travelPackage;
	}
	
	@Override
	public void update(int id, TravelPackage travelPackage) {
		String updateSQL = "UPDATE Package SET hotel_id=?,restaurant_id=?,ticket_id=?,number_of_day=?,quantity=? WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setInt(1, travelPackage.getHotel().getHotel_id());
			ps.setInt(2, travelPackage.getRestaurant().getRestaurant_id());
			ps.setInt(3, travelPackage.getTicket().getTicket_id());
			ps.setInt(4, travelPackage.getNumber_of_day());
			ps.setInt(5, travelPackage.getQuantity());
			ps.setInt(6, travelPackage.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateQuantity(int id) {
		TravelPackage travelPackage = getPackage(id);
		String updateSQL = "UPDATE Package SET quantity=? WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setInt(1, travelPackage.getQuantity()-1);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void updatePrice(int id, int price) {
		String updateSQL = "UPDATE Package SET price=? WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setInt(1, price);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public int getFlag(int id) {
		int flag = 0;
		String selectSQL = "SELECT flag FROM Package WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			flag = rs.getInt("flag");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public void updateFlag(int id) {
		String updateSQL = "UPDATE Package SET flag=? WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Integer> getFlagByHotel(int hotelId) {
		List<Integer> flagList = new ArrayList<>();
		String selectSQL = "SELECT flag FROM Package WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, hotelId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				flagList.add(rs.getInt("flag"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return flagList;
	}
	
	@Override
	public List<Integer> getFlagByRestaurant(int resId) {
		List<Integer> flagList = new ArrayList<>();
		String selectSQL = "SELECT flag FROM Package WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, resId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				flagList.add(rs.getInt("flag"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return flagList;
	}
	
	@Override
	public List<Integer> getFlagByTicket(int ticketId) {
		List<Integer> flagList = new ArrayList<>();
		String selectSQL = "SELECT flag FROM Package WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, ticketId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				flagList.add(rs.getInt("flag"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return flagList;
	}
	
	@Override
	public List<Integer> getFlagByLocation(int locId) {
		List<Integer> flagList = new ArrayList<>();
		String selectSQL = "SELECT flag FROM Package WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, locId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				flagList.add(rs.getInt("flag"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return flagList;
	}
	
	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM Package WHERE id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteByHotel(int hotelId) {
		String deleteSQL = "DELETE FROM Package WHERE hotel_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, hotelId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteByRestaurant(int resId) {
		String deleteSQL = "DELETE FROM Package WHERE restaurant_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, resId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteByTicket(int ticketId) {
		String deleteSQL = "DELETE FROM Package WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, ticketId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteByLocation(int locationId) {
		String deleteSQL = "DELETE FROM Package WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, locationId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void deleteByUser(int userId) {
		String deleteSQL = "DELETE FROM buy_package WHERE user_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<TravelPackage> getPackageByUser(int userId) {
		List<TravelPackage> packageList = new ArrayList<>();
		String selectSQL = "SELECT package_id FROM buy_package WHERE user_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				packageList.add(getPackage(rs.getInt("package_id")));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return packageList;
	}

	@Override
	public List<Integer> getAllPrice() {
		List<Integer> priceList = new ArrayList<>();
		String selectSQL = "SELECT price FROM package";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				priceList.add(rs.getInt("price"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return priceList;
	}
}
