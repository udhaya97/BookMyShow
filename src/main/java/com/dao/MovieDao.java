package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Movie;
import com.repo.MovieRepo;
@Repository
public class MovieDao implements MovieDaoIntf {

	
	@Autowired
	MovieRepo mDao;
	@Override
	public void save(Movie movie) {
		
		mDao.save(movie);
		
		
	}
	@Override
	public List<Movie> fethchById(int id) {
		List<Movie> lis = mDao.findByPlace(id);
		return lis;
	}
	@Override
	public Movie findmov(int id) {
		Movie mov= mDao.findBymId(id);
		return mov;
	}
	@Override
	public Movie findmovname(String name) {
		Movie mna =mDao.findBymName(name);
		return mna;
	}
	@Override
	public List<Movie> findMvAll() {
		List<Movie> mo =(List<Movie>) mDao.findAll();
		return mo;
	}
	@Override
	public Movie updateMov(Movie movie) {
		Movie mov =mDao.save(movie);
		return mov;
	}
	@Override
	public void deleteMovi(int id) {
		mDao.deleteById(id);
		
	}
	
	

}
