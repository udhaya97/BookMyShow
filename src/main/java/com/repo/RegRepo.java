package com.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.model.UserReg;

public interface RegRepo extends CrudRepository<UserReg, Integer> {

	@Query(value="select * from user_reg where u_name=?1",nativeQuery = true)
	UserReg findByUName(String name);

	@Query(value="select * from user_reg where u_id=?1",nativeQuery = true)
	UserReg findByuId(int id);
	
	
	

}
