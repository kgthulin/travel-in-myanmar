package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.TicketDao;
import com.myanmar.travel.persistence.TicketDbDao;
import com.myanmar.travel.vo.Ticket;

public class TicketDaoService implements TicketService {
	private TicketDao ticketDao;

	public TicketDaoService() {
		this.ticketDao = new TicketDbDao();
	}

	@Override
	public void create(Ticket ticket) {
		ticketDao.create(ticket);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return ticketDao.getAllTicket();
	}

	@Override
	public Ticket getTicket(int id) {
		return ticketDao.getTicket(id);
	}

	@Override
	public void update(int id, Ticket ticket) {
		ticketDao.update(id, ticket);
	}

	@Override
	public void delete(int id) {
		ticketDao.delete(id);
	}

	@Override
	public List<Ticket> getAllTicketByLocation(int tic_id) {
		return ticketDao.getAllTicketByLocation(tic_id);
	}

	@Override
	public void deleteByLocation(int locationId) {
		ticketDao.deleteByLocation(locationId);
	}
}
