package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.HotelDao;
import com.myanmar.travel.persistence.HotelDbDao;
import com.myanmar.travel.vo.Hotel;

public class HotelDaoService implements HotelService {
	private HotelDao hotelDao;
	
	public HotelDaoService() {
		this.hotelDao = new HotelDbDao();
	}

	@Override
	public void create(Hotel hotel) {
		hotelDao.create(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelDao.getAllHotel();
	}

	@Override
	public Hotel getHotel(int id) {
		return hotelDao.getHotel(id);
	}

	@Override
	public void update(int id, Hotel hotel) {
		hotelDao.update(id, hotel);
	}

	@Override
	public void delete(int id) {
		hotelDao.delete(id);
	}

	@Override
	public List<Hotel> getAllHotelByLocation(int loc_id) {
		return hotelDao.getAllHotelByLocation(loc_id);
	}

	@Override
	public void deleteByLocation(int locationId) {
		hotelDao.deleteByLocation(locationId);
	}
}
