package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SeatsDaoIntf;
import com.model.Seats;
@Service
@Transactional
public class SeatsService implements SeatsServiceIntf {

	@Autowired
	SeatsDaoIntf sDao;
	@Override
	public void save(Seats seat) {
		sDao.save(seat);

	}

	@Override
	public List<Seats> findAll() {
		List<Seats> sea = sDao.findAll();
		return sea;
	}

	@Override
	public List<Seats> findunametime(String tName, String time) {
		List<Seats> lis =sDao.findunametime(tName, time);
		return lis;
	}

	@Override
	public Seats findbySeats(String seat) {
		Seats sea = sDao.findbySeats(seat);
		return sea;
	}

	@Override
	public void delete(String str) {
		sDao.delete(str);
		
	}

}
