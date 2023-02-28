package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.entity.AngularCrudEntity;
import com.fa.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {

	@Query(value = "select email from loginangular where email=?1",nativeQuery =true)
	String getEmail(String email);
	@Query(value = "select password from loginangular where email=?1",nativeQuery =true)
	String getPasswordByEmail(String email);
	@Query(value = "select * from loginangular where email=?1",nativeQuery =true)
	LoginEntity getDataByName(String email);
	@Query(value = "select * from loginangular where name=?1",nativeQuery =true)
	LoginEntity getAllDataByName(String name);
	

	 @Query(value="select id from loginangular where name=?1",nativeQuery = true)
	 Long getIdByName(String name);
	
}
