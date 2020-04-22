package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.Movie;

public interface MovieRepo extends CrudRepository<Movie, Integer> {

	@Query(value="select * from movie where place_p_id=?1",nativeQuery = true)
	List<Movie> findByPlace(int id);
	//@Query(value="select * from movie where m_id=?1",nativeQuery = true)
	Movie findBymId(int id);
	//@Query(value="select * from movie where m_name=?1",nativeQuery = true)
	Movie findBymName(String name);
	void deleteById(int id);

}
