package com.myanmar.travel.persistence;

import java.util.List;

import com.myanmar.travel.vo.Location;

public interface LocationDao {
	void create(Location location);
	List<Location> getAllLocation();
	Location getLocation(int id);
	void update(int id, Location location);
	void delete(int id);
}
