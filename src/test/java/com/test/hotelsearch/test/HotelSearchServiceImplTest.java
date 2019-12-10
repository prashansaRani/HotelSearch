package com.test.hotelsearch.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.hotelsearch.dto.HotelVO;
import com.test.hotelsearch.exception.HotelSearchException;
import com.test.hotelsearch.service.HotelSearchService;

public class HotelSearchServiceImplTest {

	@Autowired
	private HotelSearchService service;
	
	HotelVO hotelVo1 = new HotelVO();
	
	public HotelSearchServiceImplTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void insertHotel()
	{
		hotelVo1.setHotelId("1");
		hotelVo1.setHotelName("Hyaat");
		hotelVo1.setHotelCity("pune");
		hotelVo1.setRoomsAvailability("Available");
		hotelVo1.setAmenities("AC,Fridge");
		hotelVo1.setRoomCost(3000);
		assertEquals(hotelVo1.getHotelId(),"1");
	}
	
	@Test
	public void getAllHotels() throws HotelSearchException
	{
		//List<HotelVO> allHotels = new ArrayList<>();
		//HotelVO h1 = new HotelVO("2","Taj","Mumbai","Not Available","TV,Fridge",30000);
		//allHotels.add(h1);
		//assertEquals(h1,service.getAllHotels());
	}
	
	@Test
	public void updateHotel()
	{
		
	}
	
	@Test
	public void deleteHotel()
	{
		
	}
	
	@Test
	public void searchByIdorName()
	{
		
	}

}
