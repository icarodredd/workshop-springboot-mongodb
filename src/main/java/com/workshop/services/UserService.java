package com.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.domain.User;
import com.workshop.dto.UserDto;
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
		if (user == null)
			throw new ObjectNoutFoundException("Object not found");
		return user;

	}

	public User insert(User user) {
		return userRepository.insert(user);

	}

	public User fromDto(UserDto user) {
		return new User(user.getId(), user.getName(), user.getEmail());

	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);

	}

	private void updateData(User oldUser, User newUser) {
		oldUser.setName(newUser.getName());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setId(newUser.getId());

	}

	public User update(User user) {
		User newUser = userRepository.findById(user.getId()).get();
		updateData(newUser, user);
		return userRepository.save(newUser);

	}

}
