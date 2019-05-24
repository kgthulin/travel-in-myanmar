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
import com.myanmar.travel.vo.Ticket;

public class TicketDbDao implements TicketDao {
	static Connection connection = null;
	
	static {
		connection = ConnectionProvider.getConnection();
	}

	private LocationService locationService = new LocationDaoService();
	
	@Override
	public void create(Ticket ticket) {
		String insertSQL = "INSERT INTO Ticket(line_name,price,location_id) VALUES(?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			ps.setString(1, ticket.getLine_name());
			ps.setInt(2, ticket.getPrice());
			ps.setInt(3, ticket.getLocation().getLocation_id());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> ticketList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Ticket";
		try(Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(selectSQL);
			while(rs.next()) {
				ticketList.add(new Ticket(rs.getInt("ticket_id"), rs.getString("line_name"), 
											rs.getInt("price"), 
											locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return ticketList;
	}

	@Override
	public Ticket getTicket(int id) {
		Ticket ticket = new Ticket();
		String selectSQL = "SELECT line_name,price,location_id FROM Ticket WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ticket.setTicket_id(id);
				ticket.setLine_name(rs.getString("line_name"));
				ticket.setPrice(rs.getInt("price"));
				ticket.setLocation(locationService.getLocation(rs.getInt("location_id")));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return ticket;
	}

	@Override
	public void update(int id, Ticket ticket) {
		String updateSQL = "UPDATE Ticket SET line_name=?,price=? WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(updateSQL)) {
			ps.setString(1, ticket.getLine_name());
			ps.setInt(2, ticket.getPrice());
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM Ticket WHERE ticket_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Ticket> getAllTicketByLocation(int loc_id) {
		List<Ticket> ticketList = new ArrayList<>();
		String selectSQL = "SELECT * FROM Ticket WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			ps.setInt(1, loc_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ticketList.add(new Ticket(rs.getInt("ticket_id"), rs.getString("line_name"), 
											rs.getInt("price"), 
											locationService.getLocation(rs.getInt("location_id"))));
			}	
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return ticketList;
	}

	@Override
	public void deleteByLocation(int locationId) {
		String deleteSQL = "DELETE FROM Ticket WHERE location_id=?";
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			ps.setInt(1, locationId);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
