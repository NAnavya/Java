package com.virtusa.cyberhealth.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtusa.cyberhealth.dto.PrescriptionDto;
import com.virtusa.cyberhealth.exception.ResourceNotFoundException;
import com.virtusa.cyberhealth.model.PrescriptionModel;
import com.virtusa.cyberhealth.repo.PrescriptionRepo;
import com.virtusa.cyberhealth.service.PrescriptionService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("")
public class PrescriptionControllerApi {
	
	
	@Autowired
	PrescriptionRepo prepo;
	
	@Autowired 
	PrescriptionService pService;
	@Autowired
	UserControllerApi usercon;
	
	
	@RequestMapping("addprescription")
	public String addPrescription() {
		return "AddPrescription";
	}
	
	  
	  @GetMapping("patient/prescription/{id}")
	  public ResponseEntity<List<PrescriptionModel>> getPrescriptionById(@PathVariable  int id){
		  List<PrescriptionModel> pList = prepo.findByPatientId(id);
	        
	        return ResponseEntity.ok(pList);
	    }
	  
	  @PostMapping("/addprescription")
	  public  String prescription(@ModelAttribute PrescriptionDto pre) {  
		  if(pre!=null) {
			  pre.setDid(usercon.a);
		  pService.addPres(pre);
		  }
	        return  "AddPrescription";
	    }
	  
	  
	  
	  @DeleteMapping("doctor/deletepre/{id}")
	    public ResponseEntity<HttpStatus> deletePrescription (@PathVariable int id){
		  
		  PrescriptionModel pre= prepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prescription model not found with id:" + id));
		  System.out.println(pre);
		  prepo.delete(pre);
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  
		  
	  }
	  
	@PutMapping("/updatePrescription/{id}")
    public ResponseEntity<PrescriptionModel> prescriptionupdate(@PathVariable int id,@RequestBody PrescriptionDto preDetails) {
	  
	  PrescriptionModel pre =prepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("prescription not found with id:" + id));
			 
    	
	  pre.setMedicine(preDetails.getMedicine());
	  pre.setDose(preDetails.getDose());
	  
	  prepo.save(pre);
        return ResponseEntity.ok(pre);
    }

}
