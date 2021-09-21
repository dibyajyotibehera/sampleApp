package com.appCompany.sampleApp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Transient
	private String phoneNumber;

}
