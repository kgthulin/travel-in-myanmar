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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LocationAction extends ActionSupport implements ModelDriven<Location>, RequestAware {
	private static final long serialVersionUID = 1L;

	private Location location = new Location();
	private LocationService locationService = new LocationDaoService();
	private List<Location> locationList;
	private RequestMap requestMap;
	private PackageService packageService = new PackageDaoService();
	private HotelService hotelService = new HotelDaoService();
	private RestaurantService restaurantService = new RestaurantDaoService();
	private TicketService ticketService = new TicketDaoService();
	
	@Override
	public Location getModel() {
		return location;
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

	public String addLocation() {
		locationService.create(location);
		return SUCCESS;
	}
	
	public String viewLocation() {
		locationList = locationService.getAllLocation();
		return SUCCESS;
	}
	
	public String setUpForUpdate() {
		locationList = locationService.getAllLocation();
		String id = ServletActionContext.getRequest().getParameter("currentId");
		Location l = locationService.getLocation(Integer.parseInt(id));
		requestMap.put("location", l);
		return SUCCESS;
	}
	
	public String updateLocation() {
		locationService.update(location.getLocation_id(), location);
		return SUCCESS;
	}
	
	public String deleteLocation() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		int locationId = Integer.parseInt(id);
		List<Integer> flagList = packageService.getFlagByLocation(locationId);
		for(int flag : flagList) {
			if(flag == 1)
				return "failDelete";
		}
		hotelService.deleteByLocation(locationId);
		restaurantService.deleteByLocation(locationId);
		ticketService.deleteByLocation(locationId);
		packageService.deleteByLocation(locationId);
		locationService.delete(locationId);
		return SUCCESS;
	}
}
