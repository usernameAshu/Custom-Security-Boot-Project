package com.mohanty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohanty.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String username);
}
