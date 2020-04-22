package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Movie;

@Service
public interface MovieServIntf {

	
	
	void save(Movie movie);
	List<Movie> fetchById(int id);
	Movie findmov(int id);
	Movie findmovname(String name);
	List<Movie> findMvAll();
	Movie updateMov(Movie movie);
	void deleteMovi(int id);
}
