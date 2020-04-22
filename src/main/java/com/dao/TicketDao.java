package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Ticket;

@Repository
public interface TicketDao {
	void save(Ticket tkt);
	Ticket findBymNameAndseatNo(String mName,String seatno, String tim,String thName);

}
