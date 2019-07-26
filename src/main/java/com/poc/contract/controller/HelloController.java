package com.poc.contract.controller;

import com.poc.contract.integration.UserClient;
import com.poc.contract.integration.dto.UserDto;
import com.poc.contract.model.User;
import com.poc.contract.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

  @Autowired
  private HelloService service;

  @Autowired
  private UserClient userClient;

  @GetMapping("/hello")
  public ResponseEntity<User> hello(@RequestParam String name) {
    return new ResponseEntity<>(service.sayHello(name), HttpStatus.OK);
  }

  @PostMapping("/hello")
  public ResponseEntity<User> saveHello(@RequestBody User user) {
    final UserDto userResponse = userClient.createUser(user);
    return new ResponseEntity<>(User.builder()
        .id(userResponse.getId())
        .name(userResponse.getName())
        .email(userResponse.getEmail())
        .build(), HttpStatus.OK);
  }

}
