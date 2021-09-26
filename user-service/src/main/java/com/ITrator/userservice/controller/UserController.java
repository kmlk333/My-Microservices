package com.ITrator.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITrator.userservice.entity.User;
import com.ITrator.userservice.service.UserService;
import com.ITrator.userservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{Id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("Id") Long userId) {
		
		return userService.getUserWithDepartment(userId);
	}
}
