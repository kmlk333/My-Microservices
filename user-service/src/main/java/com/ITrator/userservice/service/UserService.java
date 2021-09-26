package com.ITrator.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ITrator.userservice.entity.User;
import com.ITrator.userservice.repository.UserRepository;
import com.ITrator.userservice.vo.Department;
import com.ITrator.userservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
}
