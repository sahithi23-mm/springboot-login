package service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import Exception.UserNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import Repository.LoginRepository;
import entities.LoginEntity;


@Service
@Transactional
public class LoginServiceImpl  implements LoginService{
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public LoginEntity get(String emailId) {
		this.loginRepo.findByEmail(emailId).orElseThrow(()->new UserNotFoundException("User not found here"));
		return this.loginRepo.findByEmail(emailId).get();
	}

	

	
	
	

}
