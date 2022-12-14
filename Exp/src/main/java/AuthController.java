package com.examly.springapp.controller;
import java.util.*;
import java.lang.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
//import com.examly.springapp.exception.ResourceNotFoundException;
//import com.examly.springapp.model.UserModel;
//import com.examly.springapp.repository.UserModelRepository;
//import com.examly.springapp.service.UserModelService;

@RestController
public class AuthController  {
	
	@Autowired
	private SignupModelService service;
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public SignupModel loginUser (@RequestBody SignupModel user) throws Exception {

		String tempEmailId = user.getEmailId();
		
		String tempPass = user.getpassword();
		String tempRole=null;
		
		SignupModel userobj = null;
		SignupModel userobj1=null;
		
		if (tempEmailId != null && tempPass != null) 
		{ 
			userobj = service.fetchByEmailIdAndPassword (tempEmailId, tempPass); 
			if(authentication(userobj)==true)
			{
				userobj.setuser_role("admin");
			}
			else
			{
				userobj.setuser_role("user");
			}
			
		}
		if(userobj == null){
			throw new Exception("Bad Credentials");
		}
	
		return userobj;
		
	}

		@GetMapping("/userrole")
		public boolean authentication (@RequestBody SignupModel user) throws Exception {

			String tempUserRole =null;
			String tempEmailId=user.getEmailId();
			//Long id=user.getId();
			signupModel tempUserRole1 = service.fetchUserByEmailId(tempEmailId);
			//Long id=user.getId();
			if (tempUserRole1.getuser_role().equals("user")) 
			{ 
				return false;
			
			}
			
			return true;
			
		}
			
}
	

