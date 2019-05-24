package com.myanmar.travel.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

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
import com.myanmar.travel.vo.Restaurant;
import com.myanmar.travel.vo.Ticket;
import com.myanmar.travel.vo.TravelPackage;
import com.myanmar.travel.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TravelPackageAction extends ActionSupport implements ModelDriven<TravelPackage>, SessionAware {
	private static final long serialVersionUID = 1L;

	private TravelPackage travelPackage = new TravelPackage();
	private LocationService locationService = new LocationDaoService();
	private List<Location> locationList;
	private HotelService hotelService = new HotelDaoService();
	private List<Hotel> hotelList;
	private RestaurantService restaurantService = new RestaurantDaoService();
	private List<Restaurant> restaurantList;
	private TicketService ticketService = new TicketDaoService();
	private List<Ticket> ticketList;
	private PackageService packageService = new PackageDaoService();
	private List<TravelPackage> packageList;
	private HttpSession session;
	/*private RequestMap requestMap;*/
	private SessionMap<String, Object> sessionMap;
	
	@Override
	public TravelPackage getModel() {
		return travelPackage;
	}	
	
/*	@Override
	public void setRequest(Map<String, Object> map) {
		this.requestMap = (RequestMap) map;
	}*/
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = (SessionMap<String, Object>) map;
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
	
	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
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
	
	public String setUpForAddPackage() {
		hotelList = hotelService.getAllHotelByLocation(travelPackage.getLocation().getLocation_id());
		restaurantList = restaurantService.getAllRestaurantByLocation(travelPackage.getLocation().getLocation_id());
		ticketList = ticketService.getAllTicketByLocation(travelPackage.getLocation().getLocation_id());
		return SUCCESS;
	}
	
	public String addPackage() {
		return SUCCESS;
	}
	
	public String totalPrice() {
		int days = travelPackage.getNumber_of_day() - 1;
		int hotelId = travelPackage.getHotel().getHotel_id();
		int hotelPrice = hotelService.getHotel(hotelId).getPrice();
		int restaurantId = travelPackage.getRestaurant().getRestaurant_id();
		int restaurantPrice = restaurantService.getRestaurant(restaurantId).getPrice();
		int ticketId = travelPackage.getTicket().getTicket_id();
		int ticketPrice = ticketService.getTicket(ticketId).getPrice() * 2;
		int totalPrice = ((hotelPrice + restaurantPrice) * days) + ticketPrice;
		int grandTotal = totalPrice + (totalPrice / 10);
		List<Integer> priceList = packageService.getAllPrice();
		for(int price : priceList) {
			if(price == grandTotal)
				return "failToCreate";
		}
		travelPackage.setPrice(grandTotal);
		packageService.create(travelPackage);
		return SUCCESS;
	}
	
	public String viewPackage() {
		packageList = packageService.getAllPackage();
		return SUCCESS;
	}
	
	public String viewDetail() {
		packageList = packageService.getAllPackage();
		return SUCCESS;
	}
	
/*	public String setupForUpdate() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		TravelPackage pack = packageService.getPackage(Integer.parseInt(id));
		requestMap.put("pack", pack);
		hotelList = hotelService.getAllHotelByLocation(pack.getLocation().getLocation_id());
		restaurantList = restaurantService.getAllRestaurantByLocation(pack.getLocation().getLocation_id());
		ticketList = ticketService.getAllTicketByLocation(pack.getLocation().getLocation_id());
		return SUCCESS;
	}*/
	
/*	public String updatePackage() {
		packageService.update(travelPackage.getId(), travelPackage);
		int days, hotelId, hotelPrice, restaurantId, restaurantPrice, ticketId, ticketPrice, totalPrice, grandTotal;
		days = travelPackage.getNumber_of_day() - 1;
		hotelId = travelPackage.getHotel().getHotel_id();
		hotelPrice = hotelService.getHotel(hotelId).getPrice();
		restaurantId = travelPackage.getRestaurant().getRestaurant_id();
		restaurantPrice = restaurantService.getRestaurant(restaurantId).getPrice();
		ticketId = travelPackage.getTicket().getTicket_id();
		ticketPrice = ticketService.getTicket(ticketId).getPrice() * 2;
		totalPrice = ((hotelPrice + restaurantPrice) * days) + ticketPrice;
		grandTotal = totalPrice + (totalPrice / 10);
		List<Integer> priceList = packageService.getAllPrice();
		for(int price : priceList) {
			if(price == grandTotal)
				return "failToCreate";
		}
		travelPackage.setPrice(grandTotal);
		packageService.updatePrice(travelPackage.getId(), travelPackage.getPrice());
		return SUCCESS;
	}*/
	
	public String deletePackage() {
		String idString = ServletActionContext.getRequest().getParameter("currentId");
		int id = Integer.parseInt(idString);
		int flag = packageService.getFlag(id);
		if(flag == 0) {
			packageService.delete(id);
			return SUCCESS;
		}
		return "failDelete";
	}
	
	public String setupForSearchForm() {
		locationList = locationService.getAllLocation();
		return SUCCESS;
	}
	
	public String searchPackage() {
		sessionMap.put("locId", travelPackage.getLocation().getLocation_id());
		sessionMap.put("price", travelPackage.getPrice());
		packageList = packageService.getPackageByLocAndPrice(travelPackage.getLocation().getLocation_id(), 
																travelPackage.getPrice());
		return SUCCESS;
	}
	
/*	public String buyPackage() {
		session = ServletActionContext.getRequest().getSession(false);
		User u = (User) session.getAttribute("userSession");
		String packageIdStr = ServletActionContext.getRequest().getParameter("buyId");
		int packageId = Integer.parseInt(packageIdStr);
		packageService.insertBuyPackage(u.getId(), packageId);
		packageService.updateQuantity(packageId);
		packageService.updateFlag(packageId);
		return SUCCESS;
	}*/
	
	public String yourPackage() {
		session = ServletActionContext.getRequest().getSession(false);
		User u = (User) session.getAttribute("userSession");
		packageList = packageService.getPackageByUser(u.getId());
		return SUCCESS;
	}
	
/*	public String searchPackageAgain() {
		session = ServletActionContext.getRequest().getSession(false);
		Integer locId = (Integer) session.getAttribute("locId");
		int price = (int) session.getAttribute("price");
		packageList = packageService.getPackageByLocAndPrice(locId, price);
		return SUCCESS;
	}*/
}
