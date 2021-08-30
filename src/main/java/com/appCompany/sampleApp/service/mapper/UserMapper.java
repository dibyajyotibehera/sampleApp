package com.appCompany.sampleApp.service.mapper;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.dto.UserDTO;

public class UserMapper {

	public User userDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setActivated(false);
		user.setLastName(userDTO.getLastName());
		user.setFirstName(userDTO.getFirstName());
		return user;
	}

}
