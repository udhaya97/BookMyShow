package com.service;

import org.springframework.stereotype.Service;

import com.model.Ticket;

@Service
public interface TicketService {
	void save(Ticket tkt);
	
	Ticket findBymNameAndseatNoo(String mName,String seatno, String tim,String thName);

}
