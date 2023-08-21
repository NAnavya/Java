package com.virtusa.cyberhealth.service;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.cyberhealth.api.UserControllerApi;
import com.virtusa.cyberhealth.dto.BookingDto;
import com.virtusa.cyberhealth.model.BookingModel;
import com.virtusa.cyberhealth.model.UserModel;
import com.virtusa.cyberhealth.repo.BookingRepo;
import com.virtusa.cyberhealth.repo.UserRepo;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class BookingService 
{
	@Autowired
	BookingRepo  repo;
	@Autowired
	UserRepo urepo;
    @Autowired 
    UserControllerApi userCon;
    				
    	   			
    public Object createbooking(BookingDto booking) throws Exception {

    	BookingModel model = repo.findByDateAndTime(booking.getDate(),booking.getTime(),booking.getDocterId());		

    	if(model!=null) {
    		throw new Exception("Booking is not available at current slot!!!");
    	}else {
    		BookingModel bm=new BookingModel();
    	
    		//System.out.println(booking);
    		String.valueOf(booking.getDate());
    		bm.setDate(booking.getDate());
    		bm.setTime(booking.getTime());
    		bm.setBookingStatus(false);
    		bm.setPatientId(urepo.findById(userCon.a).orElseThrow());
    		//System.out.println(bm);
    		bm.setUsermodel(urepo.findById(booking.getDocterId()).orElseThrow());
    		//System.out.println(bm);
    		return repo.save(bm);
    		
    	}
    			
    		}



	public void updatebooking(BookingDto bookingDetails,int id) {
		// TODO Auto-generated method stub
		BookingModel model=repo.findById(id).orElseThrow();
		model.setDate(bookingDetails.getDate());
		model.setTime(bookingDetails.getTime());
		repo.save(model);
		
	}
    

}