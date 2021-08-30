package com.appCompany.sampleApp.service.mapper;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.dto.UserDTO;
import com.appCompany.sampleApp.util.Constants;
import org.springframework.data.mapping.model.AbstractPersistentProperty;

public class UserMapper {

	public static final String sampleApp = "sampleApp";

	public User userDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setActivated(false);
		user.setLastName(userDTO.getLastName());
		user.setFirstName(userDTO.getFirstName());
		user.setCreatedBy(Constants.APP);
		user.setLastModifiedBy(Constants.APP);
		return user;
	}

}
