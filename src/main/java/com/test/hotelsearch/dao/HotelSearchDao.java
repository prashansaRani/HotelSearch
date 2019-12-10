package com.test.hotelsearch.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.hotelsearch.model.Hotel;


@Repository
@Transactional
public interface HotelSearchDao extends JpaRepository<Hotel, String>{
	@Query(value="SELECT * FROM hotel",nativeQuery=true)
	public Optional<List<Hotel>> getAllHotels() throws SQLException;
	
	@Modifying
	//@Query(value="insert into hotel(hotel_id,hotel_name,hotel_city,roomsAvailability,amenities,roomCost) values (:id,:name,:city,:availability,:amenities,:cost)",nativeQuery=true)
	@Query(value="insert into hotel(hotel_id,hotel_name,hotel_city,rooms_availability,room_amenities,room_cost) values (:id,:name,:city,:availbility,:amenities,:cost)",nativeQuery=true)
	public void insertHotel(@Param("id") String id,
			@Param("name") String name,
			@Param("city") String city,
			@Param("availbility") String availbility,
			@Param("amenities") String amenities,
			@Param("cost") int cost
			) throws SQLException;
	
	
//	@Modifying
//	@Query(value="update hotel set hotel_name=:name, hotel_city=:city, roomsAvailability=:roomsAvailability, amenities=:amenities, roomCost=:roomCost where hotel_id=:id",nativeQuery=true)
//	public void updateHotel(
//			@Param("id") String id,
//			@Param("name") String name,
//			@Param("city") String city,
//			@Param("roomsAvailability") String roomsAvailability,
//			@Param("amenities") String amenities,
//			@Param("roomCost") int roomCost
//			) throws SQLException;
//	
	@Modifying
	@Query(value="delete from hotel where hotel_id=:id",nativeQuery=true)
	public void deleteHotel(@Param("id") String id) throws SQLException;
	
	@Query(value="select * from hotel where hotel_id=:id or hotel_name=:name",nativeQuery=true)
	public Optional<List<Hotel>> searchByIdorName(
			@Param("id") String id,
			@Param("name") String name
			) throws SQLException;

}
