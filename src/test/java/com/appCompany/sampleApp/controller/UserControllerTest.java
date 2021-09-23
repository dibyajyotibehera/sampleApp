package com.appCompany.sampleApp.controller;

import com.appCompany.sampleApp.service.UserService;
import com.appCompany.sampleApp.service.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldReturnCorrectUserGivenByService() throws Exception {
        UserDTO alex = new UserDTO();
        alex.setFirstName("alex");
        given(userService.getById(1)).willReturn(alex);

        mvc.perform(get("/api/v1/users/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName", is(alex.getFirstName())));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        UserDTO alex = new UserDTO();
        alex.setFirstName("alex");

        given(userService.createUser(alex)).willReturn(alex);
        mvc.perform(post("/api/v1/users").contentType(MediaType.APPLICATION_JSON).content(asJsonString(alex)))
            .andExpect(status().isCreated()).andExpect(jsonPath("$.firstName", is(alex.getFirstName())));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
