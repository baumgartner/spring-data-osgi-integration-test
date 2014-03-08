package at.badgateway.spring.data.osgi.tests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import at.badgateway.helloworld.domain.User;
import at.badgateway.helloworld.repository.UserRepository;

public class AuditorTest extends PluginDependencyOsgiAbstractTests {

	@Autowired
	private UserRepository repository;

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public void testInsert() {
		User u = new User();
		u.setFirstname("foo");
		u.setLastname("bar");
		repository.save(u);
	}

	public void testFindAllAndDelete() {
		List<User> users = repository.findAll();
		for (User u : users) {
			repository.delete(u);
		}

	}

}
