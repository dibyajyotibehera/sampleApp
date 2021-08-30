package com.appCompany.sampleApp.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	private String email;

	@NotNull
	private boolean activated = false;

}
