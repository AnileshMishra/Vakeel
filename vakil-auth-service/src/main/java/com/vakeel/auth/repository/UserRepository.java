package com.vakeel.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vakeel.auth.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 Optional<User> findByUsername(String username);
}
