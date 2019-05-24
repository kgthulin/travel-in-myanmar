package com.myanmar.travel.persistence;

import java.util.List;

import com.myanmar.travel.vo.TravelPackage;

public interface PackageDao {
	void create(TravelPackage travelPackage);
	List<TravelPackage> getAllPackage();
	List<TravelPackage> getPackageByLocAndPrice(int locationId, int price);
	List<TravelPackage> getPackageByHotel(int hotelId);
	List<TravelPackage> getPackageByRestaurant(int resId);
	List<TravelPackage> getPackageByTicket(int ticketId);
	void insertBuyPackage(int userId, int packageId);
	TravelPackage getPackage(int id);
	void update(int id, TravelPackage travelPackage);
	void updateQuantity(int id);
	void updatePrice(int id, int price);
	int getFlag(int id);
	void updateFlag(int id);
	List<Integer> getFlagByHotel(int hotelId);
	List<Integer> getFlagByRestaurant(int resId);
	List<Integer> getFlagByTicket(int ticketId);
	List<Integer> getFlagByLocation(int locId);
	void delete(int id);
	void deleteByHotel(int hotelId);
	void deleteByRestaurant(int resId);
	void deleteByTicket(int ticketId);
	void deleteByLocation(int locationId);
	void deleteByUser(int userId);
	List<TravelPackage> getPackageByUser(int userId);
	List<Integer> getAllPrice();
}
