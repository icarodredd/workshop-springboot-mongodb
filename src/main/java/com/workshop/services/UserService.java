package com.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.domain.User;
import com.workshop.exception.ObjectNoutFoundException;
import com.workshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User findById(String id) {
		User user = userRepository.findById(id).get();
		if (user == null) throw new ObjectNoutFoundException("Object not found");
		return user;

	}

}
