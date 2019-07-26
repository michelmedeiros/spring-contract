package com.poc.integration.controller;

import com.poc.integration.model.User;
import com.poc.integration.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

  @Autowired
  private HelloService service;

  @GetMapping("/hello")
  public ResponseEntity<User> hello(@RequestParam String name) {
    return new ResponseEntity<>(service.sayHello(name), HttpStatus.OK);
  }

  @PostMapping("/hello")
  public ResponseEntity<User> saveHello(@RequestBody User user) {
    return new ResponseEntity<>(service.saveHello(user), HttpStatus.OK);
  }

}
