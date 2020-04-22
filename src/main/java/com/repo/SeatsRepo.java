package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.Seats;

public interface SeatsRepo extends CrudRepository<Seats,Integer>{
	

@Query(value="select * from seats where th_name=?1 and timings=?2",nativeQuery = true)
	List<Seats> findByThNameAndTimings(String tName, String time);
@Query(value="select * from seats where seats=?1",nativeQuery = true)
Seats findBySeats(String seat);


void deleteBySeats(String str);
}
