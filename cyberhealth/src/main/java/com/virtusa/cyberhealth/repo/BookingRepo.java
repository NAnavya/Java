package com.virtusa.cyberhealth.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.cyberhealth.model.BookingModel;


@Repository
public interface BookingRepo extends CrudRepository<BookingModel, Integer>{
	
	List<BookingModel>findAll();
	
	@Query( value="select * from cyberhealth.booking_details b where b.date =?1 and b.time=?2 and b.doctor_id=?3",nativeQuery = true)

	BookingModel findByDateAndTime(Date date,String time,int id);

	@Query(value="select * from cyberhealth.booking_details b where b.patient_id=?1",nativeQuery =true)
	List<BookingModel> findByPatientId(Integer patientId);
	
	@Query(value="select * from cyberhealth.booking_details b where b.doctor_id=?1",nativeQuery =true)
	List<BookingModel> findByDoctorId(Integer docId);

}