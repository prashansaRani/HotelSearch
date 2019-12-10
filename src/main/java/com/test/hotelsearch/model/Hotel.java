package com.test.hotelsearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@Column(name = "hotel_id")
	private String hotelId;

	@Column(name = "hotel_name")
	private String hotelName;

	@Column(name = "hotel_city")
	private String hotelCity;

	@Column(name = "rooms_availability")
	private String roomsAvailability;

	@Column(name = "room_amenities")
	private String amenities;

	@Column(name = "room_cost")
	private int roomCost;

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
