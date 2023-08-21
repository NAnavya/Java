package com.virtusa.cyberhealth.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.cyberhealth.dto.BookingDto;
import com.virtusa.cyberhealth.exception.ResourceNotFoundException;
import com.virtusa.cyberhealth.model.BookingModel;
import com.virtusa.cyberhealth.repo.BookingRepo;
import com.virtusa.cyberhealth.repo.UserRepo;
import com.virtusa.cyberhealth.service.BookingService;


@Controller
public class BookingControllerApi {

	@Autowired
	UserRepo userrepo;

	@Autowired
	BookingRepo bookingRepo;

	@Autowired
	BookingService bookingservice;
	
	@Autowired
	UserControllerApi usercon;
	
	
	@RequestMapping("/booking")
	public String register() {
		return "Booking";
	}
	
	@RequestMapping("/updatebookingstatus")
	public String updateBooking() {
		return "UpdateStatusBooking";
	}

	
	@GetMapping("/viewallbooking")
	public ModelAndView getBookingById() {
		List<BookingModel> bookingList = bookingRepo.findByPatientId(usercon.a);
		
		ModelAndView mv=new ModelAndView("viewBookings");
		List<Map<String, Object>> output = new ArrayList<Map<String, Object>>();
		
		output.forEach(System.out::println);
		for (BookingModel booking : bookingList) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("bookingId", booking.getBookingId());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			data.put("date", formatter.format(booking.getDate()));
			data.put("patientId", booking.getPatientId());
			data.put("time", booking.getTime());
			data.put("bookingStatus", booking.getBookingStatus());
			output.add(data);
		}
		mv.addObject("output",bookingList);
		return mv;
	}
	

	@PostMapping("booking")
	public String  booking(@ModelAttribute BookingDto booking) throws Exception {
		try {
			System.out.println("ok");
			bookingservice.createbooking(booking);
			return "redirect:/booking";
			
		} catch (Exception e) {
            return "";
		}
	}

	


	@DeleteMapping("booking/delete/{id}")
	public ResponseEntity<HttpStatus> deleteBooking(@PathVariable int id) {

		BookingModel bm = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking  not found with id:" + id));

		bookingRepo.delete(bm);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	@PutMapping("/updatebooking/{id}")
	public ResponseEntity<BookingModel> updateBooking(@PathVariable int id, @RequestBody BookingDto bookingDetails) {
		BookingModel updatebooking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + id));


		try {
			bookingservice.updatebooking(bookingDetails,id);
			return new ResponseEntity<BookingModel>(updatebooking, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@RequestMapping("/aupdatebookingstatus")
	public String updateBooking(@RequestParam("status") boolean status,@RequestParam("id") int id) {
		
		BookingModel updatebooking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + id));
				updatebooking.setBookingStatus(status);
		System.out.println(status+" "+id);
				System.out.println("Booking is"+ updatebooking);
				
				bookingRepo.save(updatebooking);
				return "UpdateStatusBooking";			
        }

	}


