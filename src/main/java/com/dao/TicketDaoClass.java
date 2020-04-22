package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Ticket;
import com.repo.TicketRepo;
@Repository
public class TicketDaoClass implements TicketDao {

	@Autowired
	TicketRepo tRepo;
	@Override
	public void save(Ticket tkt) {
		tRepo.save(tkt);

	}

	@Override
	public Ticket findBymNameAndseatNo(String mName,String seatno,String tim,String thName) {
		Ticket tkt = tRepo.findBymNameAndSeatNo(mName, seatno,tim,thName);
		return tkt;
	}

}
