package com.appCompany.myApp.service;

import com.appCompany.myApp.domain.User;
import com.appCompany.myApp.repository.UserRepository;
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
