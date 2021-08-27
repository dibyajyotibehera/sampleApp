package com.appCompany.my_app.repository;

import com.appCompany.my_app.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public User findById(long id) {
		User dummyUser = new User();
		dummyUser.setId(id);
		dummyUser.setEmail("fn@ln.com");
		dummyUser.setLastName("ln");
		return dummyUser;
	}

}
