package com.appCompany.my_app.service;

import com.appCompany.my_app.domain.User;
import com.appCompany.my_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getById(long id) {
		return userRepository.findById(id);
	}

}
