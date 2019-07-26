package com.poc.contract.service;

import com.poc.contract.model.User;
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
