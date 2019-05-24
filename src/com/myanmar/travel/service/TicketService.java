package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.vo.Ticket;

public interface TicketService {
	void create(Ticket ticket);
	List<Ticket> getAllTicket();
	Ticket getTicket(int id);
	void update(int id, Ticket ticket);
	void delete(int id);
	void deleteByLocation(int locationId);
	List<Ticket> getAllTicketByLocation(int tic_id);
}
