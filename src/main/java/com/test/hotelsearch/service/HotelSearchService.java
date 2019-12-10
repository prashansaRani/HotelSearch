package com.test.hotelsearch.service;

import java.util.List;

import com.test.hotelsearch.dto.HotelVO;
import com.test.hotelsearch.exception.HotelSearchException;


public interface HotelSearchService {
    public List<HotelVO> getAllHotels() throws HotelSearchException;
	
	public void insertHotel(HotelVO hotel) throws HotelSearchException;
	
//	public void updateHotel(String id, String newname, String newCity, String newavailability, String newamenities, int newcost) throws HotelSearchException;
//	
	public void deleteHotel(String id) throws HotelSearchException;
	
	public List<HotelVO> searchByIdorName(String id, String name) throws HotelSearchException;

}
