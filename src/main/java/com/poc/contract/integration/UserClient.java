package com.poc.contract.integration;


import com.poc.contract.integration.dto.UserDto;
import com.poc.contract.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface UserClient {

  @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
  UserDto createUser(@RequestBody User user);

}
