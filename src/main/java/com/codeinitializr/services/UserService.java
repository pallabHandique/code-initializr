package com.codeinitializr.services;

import java.util.Optional;

import com.codeinitializr.models.User;
import com.codeinitializr.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void save(User user) {
        userRepository.save(user);
	}

}