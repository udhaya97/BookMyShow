package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MovieDaoIntf;
import com.model.Movie;

@Service
@Transactional
public class MovieServ implements MovieServIntf {

	@Autowired
	MovieDaoIntf mvDao;
	@Override
	public void save(Movie movie) {
		mvDao.save(movie);

	}

	@Override
	public List<Movie> fetchById(int id) {
		List<Movie> lis = mvDao.fethchById(id);
		
		return lis;
	}

	@Override
	public Movie findmov(int id) {
		Movie mov=mvDao.findmov(id);
		return mov;
	}

	@Override
	public Movie findmovname(String name) {
		Movie mna =mvDao.findmovname(name);
		return mna;
	}

	@Override
	public List<Movie> findMvAll() {
		List<Movie> mv =mvDao.findMvAll();
		return mv;
	}

	@Override
	public Movie updateMov(Movie movie) {
		Movie mvn = mvDao.updateMov(movie);
		return mvn;
	}

	@Override
	public void deleteMovi(int id) {
		mvDao.deleteMovi(id);
		
	}

}
