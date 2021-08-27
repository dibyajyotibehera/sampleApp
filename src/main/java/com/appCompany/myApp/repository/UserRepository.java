package com.appCompany.myApp.repository;

import com.appCompany.myApp.domain.User;
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
