package com.test.hotelsearch.dto;

public class HotelVO {
	private String hotelId;
	private String hotelName;
	private String hotelCity;
	private String roomsAvailability;
	private String amenities;
	private int roomCost;

	public HotelVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelVO(String hotelId, String hotelName, String hotelCity, String roomsAvailability, String amenities,
			int roomCost) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.roomsAvailability = roomsAvailability;
		this.amenities = amenities;
		this.roomCost = roomCost;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getRoomsAvailability() {
		return roomsAvailability;
	}

	public void setRoomsAvailability(String roomsAvailability) {
		this.roomsAvailability = roomsAvailability;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public int getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}

}