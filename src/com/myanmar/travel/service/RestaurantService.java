package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.vo.Restaurant;

public interface RestaurantService {
	void create(Restaurant restaurant);
	List<Restaurant> getAllRestaurant();
	Restaurant getRestaurant(int id);
	void update(int id, Restaurant restaurant);
	void delete(int id);
	void deleteByLocation(int locationId);
	List<Restaurant> getAllRestaurantByLocation(int res_id);
}
