package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Place;

@Service

public interface PlaceServ {
	List<Place> fetchPlaceAll();
	void save(Place place);
	Place findbyName(String name);
	
	Place update(Place place);
	Place findbyId(int id);
	void delete(int id);
}
