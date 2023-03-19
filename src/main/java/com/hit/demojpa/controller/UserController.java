package com.hit.demojpa.controller;

import com.hit.demojpa.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/test")
  private ResponseEntity<?> getUser(@RequestParam("username") String username) {
    return ResponseEntity.ok(userRepository.findByUsername(username));
  }

}
