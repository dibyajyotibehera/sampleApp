package com.appCompany.sampleApp.controller;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.UserService;
import com.appCompany.sampleApp.service.dto.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable long id) {
		return userService.getById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO user) {
		User savedUser = userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

		try {
			return ResponseEntity.created(new URI("/api/v1/users")).headers(headers).body(savedUser);
		}
		catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
