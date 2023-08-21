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
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.cyberhealth.exception.ResourceNotFoundException;
import com.virtusa.cyberhealth.model.CheckupModel;
import com.virtusa.cyberhealth.repo.CheckupRepo;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("")
public class CheckupControllerApi {
	
	@Autowired
	CheckupRepo checkuprepo;
	@Autowired 
	UserControllerApi usercon;
	
	@RequestMapping("/addcheckup")
	public String addCheckup() {
		return "AddCheckup";
	}
	 @GetMapping("checkupdetails")
	  public ModelAndView getPatientById(){
		  List<CheckupModel> checkupList = checkuprepo.findByPatientId(usercon.a);
	        ModelAndView mv=new ModelAndView();
	        mv.setViewName("ViewCheckup");
	        mv.addObject("checkup",checkupList);
	        return mv;
	    }	 
	  @PostMapping("/addcheckup")
	  public String checkup(@ModelAttribute CheckupModel check) {  
		  
		  if(check!=null) {
			  check.setDid(usercon.a);
		  checkuprepo.save(check);
		  }
	        return "redirect:/addcheckup" ;
	    }
	  @DeleteMapping("doctor/deletereport/{id}")
	    public ResponseEntity<HttpStatus> deleteReport (@PathVariable int id){
		  
		  CheckupModel report = checkuprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report  not found with id:" + id));
		 checkuprepo.delete(report);
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  
		  
	  }
	  
	  @PutMapping("/updatereport/{id}")
	    public ResponseEntity<CheckupModel> checkupBooking(@PathVariable int id,@RequestBody CheckupModel reportDetails) {
		  
		  CheckupModel check =checkuprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("report not found with id:" + id));
	    	
		  check.setDescription(reportDetails.getDescription());
		  check.setDisease(reportDetails.getDisease());
	    
	    	checkuprepo.save(check);

	        return ResponseEntity.ok(check);
	    }
	  
	  
}
