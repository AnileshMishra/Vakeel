package com.vakeel.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vakeel.auth.dto.JwtResponse;
import com.vakeel.auth.dto.LoginRequestDto;
import com.vakeel.auth.dto.RegisterRequest;
import com.vakeel.auth.service.AuthService;
import com.vakeel.auth.userDetailsImpl.UserDetailsServiceImpl;
import com.vakeel.auth.utiles.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
					loginRequestDto.getPassword()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(Map.of("Autherization Failuer", "Invalid username or password"));
		}

		UserDetails details = detailsServiceImpl.loadUserByUsername(loginRequestDto.getUsername());
		String token = jwtUtil.generateToken(details);

		return ResponseEntity.ok(new JwtResponse(token));

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.registerUser(request));
	}

}
