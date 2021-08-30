package com.appCompany.sampleApp.controller;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.UserService;
import com.appCompany.sampleApp.service.dto.UserDTO;
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
	public ResponseEntity<User> getById(@PathVariable long id) {
		User byId = userService.getById(id);
		return ResponseEntity.ok().body(byId);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO user) {
		User savedUser = userService.createUser(user);
		try {
			return ResponseEntity.created(new URI("/api/v1/users")).body(savedUser);
		}
		catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
