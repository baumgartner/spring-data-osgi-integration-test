package at.badgateway.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import at.badgateway.helloworld.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFirstname(String firstname);

	@Query("select u from User u where u.lastname = ?1")
	List<User> findByLastname(String lastname);
	

}
