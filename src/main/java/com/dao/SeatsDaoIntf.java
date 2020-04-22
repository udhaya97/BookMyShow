package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Seats;

@Repository
public interface SeatsDaoIntf {
	
	void save(Seats seat);
	List<Seats> findAll();
	List<Seats> findunametime(String tName,String time);
	Seats findbySeats(String seat);
	void delete(String str);
	

}
