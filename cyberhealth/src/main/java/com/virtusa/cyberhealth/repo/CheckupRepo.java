package com.virtusa.cyberhealth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.cyberhealth.model.CheckupModel;


@Repository
public interface CheckupRepo extends CrudRepository<CheckupModel,Integer> {
	
	List<CheckupModel>findAll();

	List<CheckupModel> findByPatientId(Integer userid);
	@Query(value="select *from cyberhealth.checkup_details b where b.did=?1",nativeQuery =true)
	List<CheckupModel> findByDid(Integer userid);
	
}