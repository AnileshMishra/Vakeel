package com.vakeel.auth.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vakeel.auth.dto.RegisterRequest;
import com.vakeel.auth.pojo.Role;
import com.vakeel.auth.pojo.User;
import com.vakeel.auth.repository.RoleRepository;
import com.vakeel.auth.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerUser(RegisterRequest registerRequest) {

		Set<Role> roleSet = registerRequest.getRoles().stream()
				.map(roleName -> roleRepository.findByName(roleName)
						.orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
				.collect(Collectors.toSet());

		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setRoles(roleSet);

		return userRepository.save(user);
	}
}
