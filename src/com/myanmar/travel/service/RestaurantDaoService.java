package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.RestaurantDao;
import com.myanmar.travel.persistence.RestaurantDbDao;
import com.myanmar.travel.vo.Restaurant;

public class RestaurantDaoService implements RestaurantService {
	private RestaurantDao restaurantDao;
	
	public RestaurantDaoService() {
		this.restaurantDao = new RestaurantDbDao();
	}

	@Override
	public void create(Restaurant restaurant) {
		restaurantDao.create(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantDao.getAllRestaurant();
	}

	@Override
	public Restaurant getRestaurant(int id) {
		return restaurantDao.getRestaurant(id);
	}

	@Override
	public void update(int id, Restaurant restaurant) {
		restaurantDao.update(id, restaurant);
	}

	@Override
	public void delete(int id) {
		restaurantDao.delete(id);
	}

	@Override
	public List<Restaurant> getAllRestaurantByLocation(int res_id) {
		return restaurantDao.getAllRestaurantByLocation(res_id);
	}

	@Override
	public void deleteByLocation(int locationId) {
		restaurantDao.deleteByLocation(locationId);
	}
}
