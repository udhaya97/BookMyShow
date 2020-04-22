package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Theatre;
import com.repo.TheatreRepo;
@Repository
public class TheatreDao implements TheatreDaoIntf  {

	@Autowired
	TheatreRepo thDao;
	
	@Override
	public void save(Theatre theatre) {
		thDao.save(theatre);
		
		
	}

	
	  @Override public List<Theatre> fetchTheatre(int id) {
	  
	  List<Theatre> lis =thDao.findByMovie(id); return lis; }


	@Override
	public Theatre findbytname(String tname) {
	
		Theatre the =thDao.findByTName(tname);
		return the;
	}


	@Override
	public Theatre updateTheat(Theatre theatre) {
		Theatre thr =thDao.save(theatre);
		return thr;
	}


	@Override
	public void deleteTheat(int id) {
		thDao.deleteById(id);
		
	}


	@Override
	public List<Theatre> findTheatAll() {
		List<Theatre> lis = (List<Theatre>) thDao.findAll();
		return lis;
	}
	 
	
	  @Override public Theatre getbyid(int id) { Theatre th=thDao.findByTId(id);
	  return th; }
	 

}
