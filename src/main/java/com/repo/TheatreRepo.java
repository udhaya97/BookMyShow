package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.Theatre;

public interface TheatreRepo extends CrudRepository<Theatre, Integer> {

	@Query(value="select * from theatre where movie_m_id=?1",nativeQuery=true)
	List<Theatre> findByMovie(int id);

	@Query(value="select * from theatre where t_id=?1",nativeQuery = true)
	Theatre findByTId(int id);
	@Query(value="select * from theatre where t_name=?1",nativeQuery = true)
    Theatre findByTName(String tname);

	void deleteById(int id);


	
}
