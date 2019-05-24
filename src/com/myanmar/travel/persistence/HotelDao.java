package com.myanmar.travel.persistence;

import java.util.List;

import com.myanmar.travel.vo.Hotel;

public interface HotelDao {
	void create(Hotel hotel);
	List<Hotel> getAllHotel();
	Hotel getHotel(int id);
	void update(int id, Hotel hotel);
	void delete(int id);
	void deleteByLocation(int locationId);
	List<Hotel> getAllHotelByLocation(int loc_id);
}
