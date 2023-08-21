package com.virtusa.cyberhealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.cyberhealth.dto.PrescriptionDto;
import com.virtusa.cyberhealth.model.PrescriptionModel;
import com.virtusa.cyberhealth.repo.PrescriptionRepo;
import com.virtusa.cyberhealth.repo.UserRepo;

@Service
public class PrescriptionService {
	
	@Autowired 
	private PrescriptionRepo preRepo;
    @Autowired 
    private UserRepo userRepo;
	public void addPres(PrescriptionDto pre) {
		// TODO Auto-generated method stub
		PrescriptionModel pm=new PrescriptionModel();
		pm.setDid(pre.getDid());
		pm.setBookingId(pre.getBookingId());
		pm.setDate(pre.getDate());
		pm.setDose(pre.getDose());
		pm.setMedicine(pre.getMedicine());
		pm.setUsermodel(userRepo.findById(pre.getPatientId()).orElseThrow());
		preRepo.save(pm);
	}

}
