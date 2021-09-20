package com.appCompany.sampleApp.client.dto;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings(value = { "UUF_UNUSED_FIELD", "UWF_UNWRITTEN_FIELD" })
public class ClientUserDTO {

	private int id;

	private String name;

	private String username;

	private String email;

	private Address address;

	private String phone;

	private String website;

	private Company company;

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

@SuppressFBWarnings(value = "UUF_UNUSED_FIELD")
class Geo {

	private String lat;

	private String lng;

}

@SuppressFBWarnings(value = "UUF_UNUSED_FIELD")
class Address {

	private String street;

	private String suite;

	private String city;

	private String zipcode;

	private Geo geo;

}

@SuppressFBWarnings(value = "UUF_UNUSED_FIELD")
class Company {

	private String name;

	private String catchPhrase;

	private String bs;

}
