package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.LocationDao;
import com.myanmar.travel.persistence.LocationDbDao;
import com.myanmar.travel.vo.Location;

public class LocationDaoService implements LocationService {
	
	private LocationDao locationDao;
	
	public LocationDaoService() {
		locationDao = new LocationDbDao();
	}
	
	@Override
	public void create(Location location) {
		locationDao.create(location);
	}
	
	@Override
	public List<Location> getAllLocation() {
		return locationDao.getAllLocation();
	}

	@Override
	public Location getLocation(int id) {
		return locationDao.getLocation(id);
	}

	@Override
	public void update(int id, Location location) {
		locationDao.update(id, location);
	}

	@Override
	public void delete(int id) {
		locationDao.delete(id);
	}
}
