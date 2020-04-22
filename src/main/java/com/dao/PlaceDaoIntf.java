package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Place;

@Repository
public interface PlaceDaoIntf {
	
	List<Place> fetchPlaceAll();
	
	void save(Place place);
	Place findbyName(String name);
	
	Place update(Place place);
	void delete(int id);
	Place findbyId(int id);
}
