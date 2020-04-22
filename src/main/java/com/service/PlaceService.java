/**
 * 
 */
package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlaceDaoIntf;
import com.model.Place;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class PlaceService implements PlaceServ {

	@Autowired
	PlaceDaoIntf pDao;
	

	@Override
	public List<Place> fetchPlaceAll() {
		List<Place> lis =pDao.fetchPlaceAll(); 
		return lis;
	}


	@Override
	public void save(Place place) {
		pDao.save(place);
		
	}


	@Override
	public Place findbyName(String name) {
		Place pl = pDao.findbyName(name);
		return pl;
	}



	@Override
	public Place update(Place place) {
	Place pl = pDao.update(place);
		return pl;
	}


	@Override
	public void delete(int id) {
		pDao.delete(id);
		
	}


	@Override
	public Place findbyId(int id) {
		Place pl =pDao.findbyId(id);
		return pl;
	}

}
