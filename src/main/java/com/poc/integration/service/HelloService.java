package com.poc.integration.service;

import com.poc.integration.model.User;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public User sayHello(String name) {
    return User.builder().name(name).build();
  }

  public User saveHello(User user) {
    return User.builder()
        .name(user.getName())
        .id(user.getId())
        .email("email@test.com")
        .build();
  }
}
