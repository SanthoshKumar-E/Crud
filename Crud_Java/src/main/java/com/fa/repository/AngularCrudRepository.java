package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.fa.entity.AngularCrudEntity;



@Repository
public interface AngularCrudRepository extends JpaRepository<AngularCrudEntity,Long>{
	@Query(value = "select name from angularcrud where name=?1",nativeQuery =true)
	String getName(String name);

	@Query(value = "select * from angularcrud where name=?1",nativeQuery =true)
	AngularCrudEntity getClientDataByName(String clientName);
	@Query(value = "select id from angularcrud where name=?1",nativeQuery =true)
	Long getIdByName(String clientName);

}
