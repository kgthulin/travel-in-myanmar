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
import com.myanmar.travel.vo.Restaurant;
import com.myanmar.travel.vo.TravelPackage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RestaurantAction extends ActionSupport implements ModelDriven<Restaurant>, RequestAware {
	private static final long serialVersionUID = 1L;
	
	private Restaurant restaurant = new Restaurant();
	private RestaurantService restaurantService = new RestaurantDaoService();
	private LocationService locationService = new LocationDaoService();
	private List<Location> locationList;
	private List<Restaurant> restaurantList;
	private RequestMap requestMap;
	private PackageService packageService = new PackageDaoService();
	private List<TravelPackage> packageList;
	private HotelService hotelService = new HotelDaoService();
	private TicketService ticketService = new TicketDaoService();
	
	@Override
	public Restaurant getModel() {
		return restaurant;
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
	
	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
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

	public String addRestaurant() {
		restaurantService.create(restaurant);
		return SUCCESS;
	}
	
	public String viewRestaurant() {
		restaurantList = restaurantService.getAllRestaurant();
		return SUCCESS;
	}
	
	public String setUpForUpdate() {
//		locationList = locationService.getAllLocation();
		String id = ServletActionContext.getRequest().getParameter("currentId");
		Restaurant r = restaurantService.getRestaurant(Integer.parseInt(id));
		requestMap.put("restaurant", r);
		return SUCCESS;
	}
	
	public String updateRestaurant() {
		restaurantService.update(restaurant.getRestaurant_id(), restaurant);
		packageList = packageService.getPackageByRestaurant(restaurant.getRestaurant_id());
		int days, hotelId, hotelPrice, restaurantId, restaurantPrice, ticketId, ticketPrice, totalPrice, grandTotal;
		for(TravelPackage pack : packageList) {
			restaurantService.update(pack.getRestaurant().getRestaurant_id(), restaurant);
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
	
	public String deleteRestaurant() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		int resId = Integer.parseInt(id);
		List<Integer> flagList = packageService.getFlagByRestaurant(resId);
		for(int flag : flagList) {
			if(flag == 1)
				return "failDelete";
		}
		packageService.deleteByRestaurant(resId);
		restaurantService.delete(resId);
		return SUCCESS;
	}
}
