package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.model.Theatre;

@Repository

public interface TheatreDaoIntf  {
	
	void save(Theatre theatre);
	Theatre getbyid(int id);
	List<Theatre> fetchTheatre(int id);
	Theatre findbytname(String tname);
	Theatre updateTheat(Theatre theatre);
	void deleteTheat(int id);
	List<Theatre> findTheatAll();

}
