package Exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	
	

}
