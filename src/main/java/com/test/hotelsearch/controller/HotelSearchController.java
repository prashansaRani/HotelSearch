package com.test.hotelsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.hotelsearch.dto.HotelVO;
import com.test.hotelsearch.dto.OutputVO;
import com.test.hotelsearch.exception.HotelSearchException;
import com.test.hotelsearch.service.HotelSearchService;

@RestController
@RequestMapping("/dashboard")
public class HotelSearchController {
	@Autowired
	private HotelSearchService service;

	/*
	 * 
	 * A function to view all hotels present in the System Takes no parameter,
	 * returns list of all the hotels if no students returns empty list
	 * 
	 */

	@GetMapping(value = "/viewallhotels")
	public ResponseEntity<OutputVO> getAllHotels() {
		ResponseEntity<OutputVO> response = null;
		OutputVO output = new OutputVO();
		List<HotelVO> hotels = null;
		try {
			hotels = service.getAllHotels();
			output.setHotelsList(hotels);
			response = new ResponseEntity<OutputVO>(output, HttpStatus.OK);
		} catch (HotelSearchException e) {
			response = new ResponseEntity<>(output, HttpStatus.valueOf(500));
			return response;
		}
		return response;

	}

	/*
	 * insertHotel takes Hotel (HotelVO) Object as input and returns confirmation
	 * message if insert operation was successful, else error message
	 *
	 */

	@PostMapping(value = "/addhotel", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertHotel(@RequestBody HotelVO hotelVo) {
		ResponseEntity<String> response = null;
		try {
			service.insertHotel(hotelVo);
			response = new ResponseEntity<String>("Succesfully Inserted hotel: HotelId= " + hotelVo.getHotelId()
					+ " HotelName: " + hotelVo.getHotelName(), HttpStatus.OK);
		} catch (HotelSearchException e) {
			System.out.println(e.getMsg());
			return new ResponseEntity<>("Couldnot Insert, please check if the hotel_id already exists",
					HttpStatus.valueOf(500));
		}
		return response;
	}

	/*
	 * updateHotel takes Hotel (HotelVO) Object as input and returns confirmation
	 * message if update operation was successful, else error message
	 *
	 */

//	@PostMapping(value="/updatehotel",consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> updateHotel(@RequestBody HotelVO hotelVo) {
//		ResponseEntity<String> response = null;
//		try {
//			service.updateHotel(hotelVo.getHotelId(),hotelVo.getHotelName(),hotelVo.getHotelCity(), hotelVo.getRoomsAvailability(),hotelVo.getAmenities(),hotelVo.getRoomCost());
//			response = new ResponseEntity<String>("Succesfully Updated Hotel = "+hotelVo.getHotelId()+" "+hotelVo.getHotelName(), HttpStatus.OK);
//		} catch (HotelSearchException e) {
//			return new ResponseEntity<>("Couldnot Update",HttpStatus.valueOf(500));
//		}
//		return response;
//	}
//	
	/*
	 * deleteHotel takes Hotel ID input and returns confirmation message if delete
	 * operation was successful, else error message
	 *
	 */

	@PostMapping(value = "/deletehotel")
	public ResponseEntity<String> deleteHotel(@RequestParam("id") String id) {
		ResponseEntity<String> response = null;
		try {
			service.deleteHotel(id);
			response = new ResponseEntity<String>("Successfully Deleted Hotel = " + id, HttpStatus.OK);
		} catch (HotelSearchException e) {
			return new ResponseEntity<>("Couldnot delete", HttpStatus.valueOf(500));
		}
		return response;
	}

	/*
	 * searchStudentByIdorName takes Hotel Id and Name as input and returns all the
	 * hotels who has the input ID or name pattern in them, else empty list
	 *
	 */

	@PostMapping(value = "/searchhotelbyidorname")
	public ResponseEntity<OutputVO> searchHotelByIdorName(@RequestParam("id") String id,
			@RequestParam("name") String name) {

		OutputVO output = new OutputVO();
		List<HotelVO> foundHotels = null;
		ResponseEntity<OutputVO> response = null;
		try {
			foundHotels = service.searchByIdorName(id, name);
			output.setHotelsList(foundHotels);
			response = new ResponseEntity<OutputVO>(output, HttpStatus.OK);
		} catch (HotelSearchException e) {
			return new ResponseEntity<>(output, HttpStatus.valueOf(500));
		}
		return response;
	}

}
