package at.badgateway.osgi.integration.mongodb.repository;

import org.springframework.data.repository.CrudRepository;

import at.badgateway.osgi.integration.mongodb.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
