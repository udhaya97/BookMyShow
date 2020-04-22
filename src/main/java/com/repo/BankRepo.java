package com.repo;

import java.util.List;

/*import org.springframework.data.jpa.repository.JpaRepository;*/
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;

import com.model.BankAccount;

public interface BankRepo extends CrudRepository<BankAccount, Integer> {

	@Query(value="select * from bank_account where user_reg_u_id=?1",nativeQuery = true)
	List<BankAccount> findByUserReg(int id);

	@Query(value="select * from bank_account where b_name=?1",nativeQuery = true)
	BankAccount findByBName(String name);

	@Query(value="select * from bank_account where balance=?1 and b_id=?2",nativeQuery = true)
	BankAccount findByBalanceAndBId(double bal,int id);
@Query(value="select * from bank_account where b_name=?1 and user_reg_u_id=?2",nativeQuery = true)
	BankAccount findByBnameAndUserReg(String bname, int id);

}
