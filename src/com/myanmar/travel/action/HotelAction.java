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
import com.myanmar.travel.vo.Hotel;
import com.myanmar.travel.vo.Location;
import com.myanmar.travel.vo.TravelPackage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HotelAction extends ActionSupport implements ModelDriven<Hotel>, RequestAware {
	private static final long serialVersionUID = 1L;

	private Hotel hotel = new Hotel();
	private HotelService hotelService = new HotelDaoService();
	private LocationService locationService = new LocationDaoService();
	private List<Location> locationList;	
	private List<Hotel> hotelList;
	private RequestMap requestMap;
	private PackageService packageService = new PackageDaoService();
	private List<TravelPackage> packageList;
	private RestaurantService restaurantService = new RestaurantDaoService();
	private TicketService ticketService = new TicketDaoService();
	
	@Override
	public Hotel getModel() {
		return hotel;
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
	
	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
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

	public String addHotel() {
		hotelService.create(hotel);
		return SUCCESS;
	}
	
	public String viewHotel() {
		hotelList = hotelService.getAllHotel();
		return SUCCESS;
	}
	
	public String setUpForUpdate() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		Hotel h = hotelService.getHotel(Integer.parseInt(id));
		requestMap.put("hotel", h);
		return SUCCESS;
	}
	
	public String updateHotel() {
		hotelService.update(hotel.getHotel_id(), hotel);
		packageList = packageService.getPackageByHotel(hotel.getHotel_id());
		int days, hotelId, hotelPrice, restaurantId, restaurantPrice, ticketId, ticketPrice, totalPrice, grandTotal;
		for(TravelPackage pack : packageList) {
			hotelService.update(pack.getHotel().getHotel_id(), hotel);
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
	
	public String deleteHotel() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		int hotelId = Integer.parseInt(id);
		List<Integer> flagList = packageService.getFlagByHotel(hotelId);
		for(int flag : flagList) {
			if(flag == 1)
				return "failDelete";
		}
		packageService.deleteByHotel(hotelId);
		hotelService.delete(hotelId);
		return SUCCESS;
	}
}
