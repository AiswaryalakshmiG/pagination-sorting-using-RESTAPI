package com.example.pagination.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.pagination.model.User;

public interface UserService {
	User saveUser(User user);

	List<User> getUserList();

	User updateUser(User user, Long userId);

	void deleteUserById(Long UserId);

	Page<User> getUsersWithPaginationAndSorting(int page, int size, String sortBy, String sortDir);
}
