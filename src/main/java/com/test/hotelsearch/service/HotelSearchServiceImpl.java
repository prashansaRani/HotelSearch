package com.test.hotelsearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.hotelsearch.dao.HotelSearchDao;
import com.test.hotelsearch.dto.HotelVO;
import com.test.hotelsearch.exception.HotelSearchException;
import com.test.hotelsearch.model.Hotel;

@Service
public class HotelSearchServiceImpl implements HotelSearchService {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(HotelSearchServiceImpl.class);

	@Autowired
	private HotelSearchDao dao;

	@Override
	public List<HotelVO> getAllHotels() throws HotelSearchException {
		Optional<List<Hotel>> hotels = Optional.empty();
		List<HotelVO> allHotels = new ArrayList<>();
		int size = 0;
		try {
			hotels = dao.getAllHotels();
			if (hotels.isPresent()) {
				allHotels = hotels.get().stream()
						.map(a -> new HotelVO(a.getHotelId(), a.getHotelName(), a.getHotelCity(),
								a.getRoomsAvailability(), a.getAmenities(), a.getRoomCost()))
						.collect(Collectors.toList());
			}
			size = allHotels.size();
			logger.info("No of Hotels: {}", size);

		} catch (Exception e) {
			logger.info("Exception Occured : {}", e.getMessage());
			logger.error("Exception: {}", e);
			throw new HotelSearchException(e);
		}
		return allHotels;
	}

	@Override
	public void insertHotel(HotelVO hotelVo) throws HotelSearchException {

		try {
			dao.insertHotel(hotelVo.getHotelId(), hotelVo.getHotelName(), hotelVo.getHotelCity(),
					hotelVo.getRoomsAvailability(), hotelVo.getAmenities(), hotelVo.getRoomCost());
		} catch (Exception e) {
			logger.info("Exception Occured : {}", e.getMessage());
			logger.error("Exception: {}", e);
			throw new HotelSearchException(e);
		}
	}

//	@Override
//	public void updateHotel(String id, String newname, String newCity, String newavailability, String newamenities, int newcost) throws HotelSearchException {
//		                    
//		try {
//			Optional<Hotel> hotel = dao.findById(id);
//			//StudentVO updateStudent = new StudentVO();
//			Hotel ht = new Hotel();
//			if(hotel.isPresent()) {
//				
//				ht = hotel.get();
//				if(newname.length() == 0)
//					newname = ht.getHotelName();
//				if(newCity.length() == 0)
//					newCity = ht.getHotelCity();
//				if(newavailability == null)
//					newavailability = ht.getRoomsAvailability();
//				if(newamenities == null)
//					newamenities = ht.getAmenities();				
//				if((int)newcost == 0)
//					newcost = ht.getRoomCost();
//				
//			}else {
//			
//				throw new HotelSearchException("Hotel Not Found");
//			}
//			
//			dao.updateHotel(id, newname, newCity, newavailability, newamenities, newcost);
//			
//		} catch (Exception e) {
//			logger.info("Exception Occured : {}",e.getMessage());
//			logger.error("Exception: {}",e);
//			throw new HotelSearchException(e);
//		}
//		
//	}
//
	@Override
	public void deleteHotel(String id) throws HotelSearchException {

		try {
			dao.deleteHotel(id);
		} catch (Exception e) {
			logger.info("Exception Occured : {}", e.getMessage());
			logger.error("Exception: {}", e);
			throw new HotelSearchException(e);
		}
	}

	@Override
	public List<HotelVO> searchByIdorName(String id, String name) throws HotelSearchException {

		Optional<List<Hotel>> hotels = Optional.empty();
		List<HotelVO> allHotels = new ArrayList<>();
		int size = 0;
		try {
			hotels = dao.searchByIdorName(id, name);
			if (hotels.isPresent()) {
				allHotels = hotels.get().stream()
						.map(a -> new HotelVO(a.getHotelId(), a.getHotelName(), a.getHotelCity(),
								a.getRoomsAvailability(), a.getAmenities(), a.getRoomCost()))
						.collect(Collectors.toList());
			}
			size = allHotels.size();
			logger.info("Hotels found : {}", size);
		} catch (Exception e) {
			logger.info("Exception Occured : {}", e.getMessage());
			logger.error("Exception: {}", e);
			throw new HotelSearchException(e);
		}
		return allHotels;
	}

}
