package com.appCompany.sampleApp.service;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.repository.UserRepository;
import com.appCompany.sampleApp.service.dto.UserDTO;
import com.appCompany.sampleApp.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getById(long id) {
		return userRepository.findById(id).get();
	}

	public User createUser(UserDTO user) {
		return userRepository.save(new UserMapper().userDTOToUser(user));
	}

}
