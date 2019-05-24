package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.vo.Location;

public interface LocationService {
	void create(Location location);
	List<Location> getAllLocation();
	Location getLocation(int id);
	void update(int id, Location location);
	void delete(int id);
}
