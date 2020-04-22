package com.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.Ticket;

public interface TicketRepo extends CrudRepository<Ticket, Integer>{

	@Query(value="select * from ticket where m_name=?1 and seat_no=?2 and timing=?3 and th_name=?4",nativeQuery = true)
	Ticket findBymNameAndSeatNo(String mName,String seatno,String tim,String thName);

}
