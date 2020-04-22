package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Place;
import com.repo.PlaceRepo;
@Repository
public class PlaceDao implements PlaceDaoIntf {
	
	@Autowired
	PlaceRepo placeDao;

	@Override
	public List<Place> fetchPlaceAll() {
		
		
		
		List<Place> place =(List<Place>) placeDao.findAll();
		return place;
	}

	@Override
	public void save(Place place) {
		placeDao.save(place);
		
		
	}

	@Override
	public Place findbyName(String name) {
		Place pl = placeDao.findByPName(name);
		return pl;
	}

	

	@Override
	public Place update(Place place) {
		Place pli =placeDao.save(place);
		return pli;
	}

	@Override
	public void delete(int id) {
		placeDao.deleteById(id);
		
	}

	@Override
	public Place findbyId(int id) {
		Place pkl = placeDao.findByPId(id);
		return pkl;
	}

}
