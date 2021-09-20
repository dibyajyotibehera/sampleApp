package com.appCompany.sampleApp.repository;

import com.appCompany.sampleApp.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void shouldReturnCorrectUser() {
		User alex = new User();
		alex.setId(1L);
		alex.setFirstName("alex");
		alex.setPhoneNumber("001");
		alex.setActivated(false);
		alex.setCreatedBy("Test");

		// given
		userRepository.save(alex);
		entityManager.flush();

		// when
		User found = userRepository.findById(1L).get();

		// then
		assertEquals(found.getFirstName(), "alex", "got wrong name");
	}

}
