package com.appCompany.sampleApp.service;

import com.appCompany.sampleApp.client.UserClient;
import com.appCompany.sampleApp.client.dto.ClientUserDTO;
import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.repository.UserRepository;
import com.appCompany.sampleApp.service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserClient userClient;

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService(UserRepository userRepository, UserClient userClient) {
            return new UserService(userRepository, userClient);
        }

    }

    @Autowired
    private UserService userService;

    @Test
    void shouldReturnCorrectUser() {
        User alex = new User();
        alex.setFirstName("alex");
        ClientUserDTO extraInfo = new ClientUserDTO();
        extraInfo.setPhone("1-770-736-8031 x56442");

        given(userRepository.findById(1L)).willReturn(Optional.of(alex));
        given(userClient.getUserById(1L)).willReturn(extraInfo);

        UserDTO byId = userService.getById(1);
        assertEquals("1-770-736-8031 x56442", byId.getPhoneNumber(), "got wrong phone num");
        assertEquals("alex", byId.getFirstName(), "got wrong name");

    }

}
