package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.LoginEntity;
import entities.signupEntity;
import service.LoginService;

@Repository
public interface LoginRepository extends JpaRepository<signupEntity, Long> {
	
	//public LoginService findByEmail(String emailId);

	//public Optional<LoginEntity> findByEmail(String emailId);

	public Optional<LoginEntity> findByEmail(String emailId);

	
	
}
