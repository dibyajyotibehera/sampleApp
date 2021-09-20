package com.appCompany.sampleApp.controller;

import com.appCompany.sampleApp.domain.User;
import com.appCompany.sampleApp.service.UserService;
import com.appCompany.sampleApp.service.dto.UserDTO;
import org.springframework.cloud.util.ConditionalOnBootstrapDisabled;
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
	public ResponseEntity<UserDTO> getById(@PathVariable long id) {
		UserDTO user = userService.getById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping()
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
		UserDTO savedUser = userService.createUser(user);
		try {
			return ResponseEntity.created(new URI("/api/v1/users")).body(savedUser);
		}
		catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

}
