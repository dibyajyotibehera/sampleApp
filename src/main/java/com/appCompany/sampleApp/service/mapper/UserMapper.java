package com.appCompany.sampleApp.service.mapper;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.dto.UserDTO;
import com.appCompany.sampleApp.util.Constants;

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

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setLastName(user.getLastName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

}
