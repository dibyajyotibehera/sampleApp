package com.appCompany.sampleApp.service;

import com.appCompany.sampleApp.client.UserClient;
import com.appCompany.sampleApp.client.dto.ClientUserDTO;
import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.repository.UserRepository;
import com.appCompany.sampleApp.service.dto.UserDTO;
import com.appCompany.sampleApp.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserClient userClient;

    public UserService(UserRepository userRepository, UserClient userClient) {
        this.userRepository = userRepository;
        this.userClient = userClient;
    }

    public UserDTO getById(long id) {
        User user = userRepository.findById(id).get();
        ClientUserDTO clientUser = userClient.getUserById(id);
        user.setPhoneNumber(clientUser.getPhone());
        return (new UserMapper().userToUserDTO(user));
    }

    public UserDTO createUser(UserDTO user) {
        User savedUser = userRepository.save(new UserMapper().userDTOToUser(user));
        return (new UserMapper().userToUserDTO(savedUser));
    }

}
