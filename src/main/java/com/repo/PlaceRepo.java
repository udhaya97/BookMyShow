package com.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.Place;

public interface PlaceRepo extends CrudRepository<Place, Integer>{

	@Query(value="select * from place where p_name=?1",nativeQuery = true)
	Place findByPName(String name);

	@Query(value="select * from place where p_id=?1",nativeQuery = true)
	Place findByPId(int id);

	void deleteById(int id);

	
	
	
	
}
