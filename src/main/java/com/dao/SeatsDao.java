package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Seats;
import com.repo.SeatsRepo;
@Repository
public class SeatsDao implements SeatsDaoIntf {

	@Autowired
	SeatsRepo sRepo;
	@Override
	public void save(Seats seat) {
		sRepo.save(seat);

	}

	@Override
	public List<Seats> findAll() {

List<Seats> sea =(List<Seats>) sRepo.findAll();
		
		return sea;
	}

	@Override
	public List<Seats> findunametime(String tName, String time) {
		List<Seats> lis =sRepo.findByThNameAndTimings(tName,time);
		
		return lis;
	}

	@Override
	public Seats findbySeats(String seat) {
		Seats sea = sRepo.findBySeats(seat);
		return sea;
	}

	@Override
	public void delete(String str) {
		
		sRepo.deleteBySeats(str);
		
	}

}
