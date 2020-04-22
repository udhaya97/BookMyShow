package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Seats;

@Service
public interface SeatsServiceIntf {
	void save(Seats seat);
	List<Seats> findAll();
	List<Seats> findunametime(String tName,String time);
	Seats findbySeats(String seat);
	void delete(String str);
}
