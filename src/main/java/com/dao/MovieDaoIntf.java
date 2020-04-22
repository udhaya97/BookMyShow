package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Movie;

@Repository
public interface MovieDaoIntf {
	
	void save(Movie movie);
	List<Movie> fethchById(int id);
	Movie findmov(int id);
	Movie findmovname(String name);
	List<Movie> findMvAll();
	Movie updateMov(Movie movie);
	void deleteMovi(int id);
}
