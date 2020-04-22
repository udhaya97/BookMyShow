package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Theatre;

@Service
public interface TheatreServIntf {
	
	void saveTheatre(Theatre theatre);
	List<Theatre> fetchById(int id);
	Theatre findbytname(String tname);
	Theatre updateTheat(Theatre theatre);
	void deleteTheat(int id);
	List<Theatre> findTheatAll();
	Theatre getbyid(int id);
}
