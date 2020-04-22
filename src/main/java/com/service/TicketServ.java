package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TicketDao;
import com.model.Ticket;
@Service
@Transactional

public class TicketServ implements TicketService {

	@Autowired
	TicketDao tDao;
	
	@Override
	public void save(Ticket tkt) {
		tDao.save(tkt);
	}

	@Override
	public Ticket findBymNameAndseatNoo(String mName, String seatno,String tim,String thName) {
		Ticket txt =tDao.findBymNameAndseatNo(mName, seatno,tim,thName);
		return txt;
	}

	

}
