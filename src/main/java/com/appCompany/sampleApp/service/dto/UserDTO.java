package com.appCompany.sampleApp.service.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	private String email;

}
