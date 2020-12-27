package com.apoorva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoorva.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUserName(String userName);
}
