package service;

import java.util.Optional;
import java.util.List;

import entities.LoginEntity;

public interface LoginService {
	
	//void insert(LoginEntity u);
	//List<LoginEntity> getAll();
	//Object<LoginEntity> get(String emailId);
	//void delete(String emailId);
	//void update (String emailId,LoginEntity e);
	//Optional<LoginEntity> orElseThrow(Object object);

	LoginEntity get(String emailId);

	//Optional<LoginEntity> orElseThrow(Object object);
	
	

}
