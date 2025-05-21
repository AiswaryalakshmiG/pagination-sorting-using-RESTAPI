package com.example.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pagination.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
