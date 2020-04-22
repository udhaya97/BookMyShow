package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TheatreDaoIntf;
import com.model.Theatre;

@Service
@Transactional
public class TheatreServ implements TheatreServIntf {

	@Autowired
	TheatreDaoIntf tDao;
	
	@Override
	public void saveTheatre(Theatre theatre) {
		
  tDao.save(theatre);
	}

	
	  @Override public List<Theatre> fetchById(int id) {
	  
	  
	  List<Theatre> lis =tDao.fetchTheatre(id); return lis; }


	@Override
	public Theatre findbytname(String tname) {
		
		Theatre the =tDao.findbytname(tname);
		return the;
	}


	@Override
	public Theatre updateTheat(Theatre theatre) {
		Theatre thr =tDao.updateTheat(theatre);
		return thr;
	}


	@Override
	public void deleteTheat(int id) {
		
		tDao.deleteTheat(id);
		
	}


	@Override
	public List<Theatre> findTheatAll() {
		List<Theatre> lis = tDao.findTheatAll();
		return lis;
	}


	@Override
	public Theatre getbyid(int id) {
		Theatre the =tDao.getbyid(id);
		return the;
	}
	 

}
