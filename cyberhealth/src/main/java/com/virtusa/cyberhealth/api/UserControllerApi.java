package com.virtusa.cyberhealth.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.virtusa.cyberhealth.dto.UserDto;
import com.virtusa.cyberhealth.exception.BadCredentialsException;
import com.virtusa.cyberhealth.exception.EmailAlreadyExistsException;
import com.virtusa.cyberhealth.exception.ResourceNotFoundException;
import com.virtusa.cyberhealth.model.BookingModel;
import com.virtusa.cyberhealth.model.Status;
import com.virtusa.cyberhealth.model.UserModel;
import com.virtusa.cyberhealth.repo.BookingRepo;
import com.virtusa.cyberhealth.repo.UserRepo;
import com.virtusa.cyberhealth.service.UserService;


@Controller
@CrossOrigin(origins = "*")

public class UserControllerApi {
	
	public static int a;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	
	@Autowired
    UserRepo userRepository;
	
	@Autowired
	UserService services;
	
	@RequestMapping("/home")
	public String home() {
		return "Home";
	}
	@RequestMapping("/register")
	public String register() {
		return "Register";
	}
	@RequestMapping("/login")
	public String login() {
		return "Login";
	}
	@RequestMapping("/addDoctor")
	public String addDoctor() {
		return "AddDoctor";
	}
	@PostMapping("/addDoctor")
	public String addDoctor(@ModelAttribute UserModel user) {
		UserModel cust = userRepository.findByEmail(user.getEmail());
		if (cust == null) {

			UserModel cust2 = userRepository.findByMobileNumber(user.getMobileNumber());
			if (cust2 == null && user!=null) {

				//UserModel user1 = services.adduser(user);
			//	user.setRole("doctor");
				userrepo.save(user);

				return "redirect:/welcome";
			}
			else
			{
				throw new EmailAlreadyExistsException("Mobile Number already exists");
			}
			}
			
		 else
			throw new EmailAlreadyExistsException("Data not submitted");
	}
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView mv=new ModelAndView("Welcome");
		UserModel user=userrepo.findById(a).orElseThrow();
		//String name=user.getUsername();
		mv.addObject("user",user);		
		//mv.addObject(mv)
		return mv;
	}
	@RequestMapping("/welcomeDoctor")
	public ModelAndView welcomeDoctor() {
		ModelAndView mv=new ModelAndView("WelcomeDoctor");
		UserModel user=userrepo.findById(a).orElseThrow();
		//String name=user.getUsername();
		mv.addObject("user",user);		
		//mv.addObject(mv)
		return mv;
	}
	@GetMapping("/doctordetails")
	  public  ModelAndView getUserbyRole(){
		  List<UserModel> userlist = userRepository.findByRole("doctor"); 
		  ModelAndView mv=new ModelAndView("DoctorDetails");
		  mv.addObject("userlist",userlist);
		//  System.out.println("hii");
	        return mv;
	    }
	
	@GetMapping("doctorbookings")
    public ModelAndView Doctorhome (){
		List<BookingModel> list =bookingRepo.findByDoctorId(a);
		list.forEach(System.out::println);
		ModelAndView  mv=new ModelAndView();
		mv.setViewName("DoctorBookings");
		mv.addObject("list", list);
		return mv;
	}
	
	@PostMapping("/saveUser")
	public String createPolicy(@ModelAttribute UserModel user) {

		UserModel cust = userRepository.findByEmail(user.getEmail());
		if (cust == null) {

			UserModel cust2 = userRepository.findByMobileNumber(user.getMobileNumber());
			if (cust2 == null && user!=null) {

				//UserModel user1 = services.adduser(user);
				userrepo.save(user);

				return "Home";
			}
			else
			{
				throw new EmailAlreadyExistsException("Mobile Number already exists");
			}
			}
			
		 else
			throw new EmailAlreadyExistsException("Data not submitted");
	}
	
    
    @PostMapping("/login")
	public ModelAndView authorize(@RequestParam("email") String email1,@RequestParam("password") String password1) {
		String email = email1;
		String password = password1;
		System.out.println(email1);
		ModelAndView mv=new ModelAndView();
		UserModel user = userRepository.findByEmailAndPassword(email, password);
		
		if(user.getRole().equals("doctor")&user != null) {
			mv.setViewName("WelcomeDoctor");
		}
		else {
			mv.setViewName("Welcome");
		}
		
		if(user != null) {
		mv.addObject("user",user);
		a=user.getId();
			return mv;
		} 
         else
			throw new BadCredentialsException("Invalid Username or Password");
	}    
    @PostMapping("/logout")
    public Status logUserOut(@Validated @RequestBody UserModel user) {
        List<UserModel> users = userRepository.findAll();
        for (UserModel other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser (@PathVariable int id){
    	
    	UserModel u =userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + id));
    	userrepo.delete(u);
    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
    
    
    @PutMapping("/updatedoctor/active/{id}")
    public ResponseEntity<UserModel> updateuser(@PathVariable int id,@RequestBody UserDto user)
    {
    	UserModel usermodel = userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id:" + id));
    	usermodel.setActive(user.getActive());
    	usermodel.setEmail(user.getEmail());
    	usermodel.setPassword(user.getPassword());
    	usermodel.setConfirmpassword(user.getConfirmpassword());
    	usermodel.setMobileNumber(user.getMobileNumber());
    	usermodel.setUsername(user.getUsername());
    	userRepository.save(usermodel);
    	 return ResponseEntity.ok(usermodel);
    	
    }   	
}
    
