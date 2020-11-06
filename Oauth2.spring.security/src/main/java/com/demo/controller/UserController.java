package com.demo.controller;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/getUserDetails")
	public  ResponseEntity<?> userdetails(User user) {
		HashMap<String, Object> resbody = new HashMap<String, Object>();
        resbody.put("msg", "User details have been retrived successfully.");
        resbody.put("status", 200);
        resbody.put("body" , repo.findAll());
        return new ResponseEntity<>(resbody, HttpStatus.OK);
		
  }
	
	@PostMapping(value = "/createUser" )
	public ResponseEntity<?> create(@RequestBody User user) {
		
		HashMap<String, Object> resbody = new HashMap<String, Object>();
        resbody.put("msg", "User created successfully.");
        resbody.put("status", 200);
        resbody.put("body" , repo.save(user));
        return new ResponseEntity<>(resbody, HttpStatus.OK);
		
   }

}
