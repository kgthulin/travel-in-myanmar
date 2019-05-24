package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.PackageDao;
import com.myanmar.travel.persistence.PackageDbDao;
import com.myanmar.travel.vo.TravelPackage;

public class PackageDaoService implements PackageService {
	private PackageDao packageDao;
	
	public PackageDaoService() {
		this.packageDao = new PackageDbDao();
	}

	@Override
	public void create(TravelPackage travelPackage) {
		packageDao.create(travelPackage);
	}

	@Override
	public List<TravelPackage> getAllPackage() {
		return packageDao.getAllPackage();
	}

	@Override
	public List<TravelPackage> getPackageByLocAndPrice(int locationId, int price) {
		return packageDao.getPackageByLocAndPrice(locationId, price);
	}
	
	@Override
	public List<TravelPackage> getPackageByHotel(int hotelId) {
		return packageDao.getPackageByHotel(hotelId);
	}
	
	@Override
	public List<TravelPackage> getPackageByRestaurant(int resId) {
		return packageDao.getPackageByRestaurant(resId);
	}
	
	@Override
	public List<TravelPackage> getPackageByTicket(int ticketId) {
		return packageDao.getPackageByTicket(ticketId);
	}

	@Override
	public void insertBuyPackage(int userId, int packageId) {
		packageDao.insertBuyPackage(userId, packageId);
	}

	@Override
	public TravelPackage getPackage(int id) {
		return packageDao.getPackage(id);
	}
	
	@Override
	public void update(int id, TravelPackage travelPackage) {
		packageDao.update(id, travelPackage);
	}

	@Override
	public void updateQuantity(int id) {
		packageDao.updateQuantity(id);
	}
	
	@Override
	public void updatePrice(int id, int price) {
		packageDao.updatePrice(id, price);
	}
	
	@Override
	public int getFlag(int id) {
		return packageDao.getFlag(id);
	}
	
	@Override
	public void updateFlag(int id) {
		packageDao.updateFlag(id);
	}
	
	@Override
	public List<Integer> getFlagByHotel(int hotelId) {
		return packageDao.getFlagByHotel(hotelId);
	}
	
	@Override
	public List<Integer> getFlagByRestaurant(int resId) {
		return packageDao.getFlagByRestaurant(resId);
	}
	
	@Override
	public List<Integer> getFlagByTicket(int ticketId) {
		return packageDao.getFlagByHotel(ticketId);
	}
	
	@Override
	public List<Integer> getFlagByLocation(int locId) {
		return packageDao.getFlagByLocation(locId);
	}
	
	@Override
	public void delete(int id) {
		packageDao.delete(id);
	}

	@Override
	public void deleteByHotel(int hotelId) {
		packageDao.deleteByHotel(hotelId);
	}

	@Override
	public void deleteByRestaurant(int resId) {
		packageDao.deleteByRestaurant(resId);
	}

	@Override
	public void deleteByTicket(int ticketId) {
		packageDao.deleteByTicket(ticketId);
	}

	@Override
	public void deleteByLocation(int locationId) {
		packageDao.deleteByLocation(locationId);
	}
	
	@Override
	public void deleteByUser(int userId) {
		packageDao.deleteByUser(userId);
	}

	@Override
	public List<TravelPackage> getPackageByUser(int userId) {
		return packageDao.getPackageByUser(userId);
	}

	@Override
	public List<Integer> getAllPrice() {
		return packageDao.getAllPrice();
	}
}
