package com.virtusa.cyberhealth.repo;

import java.util.List;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.virtusa.cyberhealth.model.PrescriptionModel;

@Repository
public interface PrescriptionRepo extends CrudRepository<PrescriptionModel,Integer> {
	
	List<PrescriptionModel>findAll();
	
	
	
	@Query(value="select *from cyberhealth.prescription_details b where b.patient_id=?1",nativeQuery =true)
	List<PrescriptionModel>findByPatientId(Integer userid);

	
	@Query(value="select *from cyberhealth.prescription_details b where b.did=?1",nativeQuery =true)
	List<PrescriptionModel> findByDoctorId(Integer userid);

}