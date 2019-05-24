package com.myanmar.travel.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.interceptor.RequestAware;

import com.myanmar.travel.service.HotelDaoService;
import com.myanmar.travel.service.HotelService;
import com.myanmar.travel.service.LocationDaoService;
import com.myanmar.travel.service.LocationService;
import com.myanmar.travel.service.PackageDaoService;
import com.myanmar.travel.service.PackageService;
import com.myanmar.travel.service.RestaurantDaoService;
import com.myanmar.travel.service.RestaurantService;
import com.myanmar.travel.service.TicketDaoService;
import com.myanmar.travel.service.TicketService;
import com.myanmar.travel.vo.Location;
import com.myanmar.travel.vo.Ticket;
import com.myanmar.travel.vo.TravelPackage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TicketAction extends ActionSupport implements ModelDriven<Ticket>, RequestAware {
	private static final long serialVersionUID = 1L;

	private Ticket ticket = new Ticket();
	private TicketService ticketService = new TicketDaoService();
	private LocationService locationService = new LocationDaoService();
	private List<Location> locationList;
	private List<Ticket> ticketList;
	private RequestMap requestMap;
	private PackageService packageService = new PackageDaoService();
	private List<TravelPackage> packageList;
	private HotelService hotelService = new HotelDaoService();
	private RestaurantService restaurantService = new RestaurantDaoService();

	@Override
	public Ticket getModel() {
		return ticket;
	}
	
	@Override
	public void setRequest(Map<String, Object> map) {
		this.requestMap = (RequestMap) map;
	}
	
	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
	
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	
	public List<TravelPackage> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<TravelPackage> packageList) {
		this.packageList = packageList;
	}

	public String setUpForLocation() {
		locationList = locationService.getAllLocation();
		return SUCCESS;
	}
	
	public String addTicket() {
		ticketService.create(ticket);
		return SUCCESS;
	}
	
	public String viewTicket() {
		ticketList = ticketService.getAllTicket();
		return SUCCESS;
	}
	
	public String setUpForUpdate() {
//		locationList = locationService.getAllLocation();
		String id = ServletActionContext.getRequest().getParameter("currentId");
		Ticket t = ticketService.getTicket(Integer.parseInt(id));
		requestMap.put("ticket", t);
		return SUCCESS;
	}
	
	public String updateTicket() {
		ticketService.update(ticket.getTicket_id(), ticket);
		packageList = packageService.getPackageByTicket(ticket.getTicket_id());
		int days, hotelId, hotelPrice, restaurantId, restaurantPrice, ticketId, ticketPrice, totalPrice, grandTotal;
		for(TravelPackage pack : packageList) {
			ticketService.update(pack.getTicket().getTicket_id(), ticket);
			days = pack.getNumber_of_day() - 1;
			hotelId = pack.getHotel().getHotel_id();
			hotelPrice = hotelService.getHotel(hotelId).getPrice();
			restaurantId = pack.getRestaurant().getRestaurant_id();
			restaurantPrice = restaurantService.getRestaurant(restaurantId).getPrice();
			ticketId = pack.getTicket().getTicket_id();
			ticketPrice = ticketService.getTicket(ticketId).getPrice() * 2;
			totalPrice = ((hotelPrice + restaurantPrice) * days) + ticketPrice;
			grandTotal = totalPrice + (totalPrice / 10);
			pack.setPrice(grandTotal);
			packageService.updatePrice(pack.getId(), pack.getPrice());
		}
		return SUCCESS;
	}
	
	public String deleteTicket() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		int ticketId = Integer.parseInt(id);
		List<Integer> flagList = packageService.getFlagByTicket(ticketId);
		for(int flag : flagList) {
			if(flag == 1)
				return "failDelete";
		}
		packageService.deleteByTicket(ticketId);
		ticketService.delete(ticketId);
		return SUCCESS;
	}
}
