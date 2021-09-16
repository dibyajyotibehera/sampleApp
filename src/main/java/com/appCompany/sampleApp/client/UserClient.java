package com.appCompany.sampleApp.client;

import com.appCompany.sampleApp.client.dto.ClientUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "fakeUserClient", url = "https://jsonplaceholder.typicode.com/")
public interface UserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	ClientUserDTO getUserById(@PathVariable("userId") Long userId);

}
