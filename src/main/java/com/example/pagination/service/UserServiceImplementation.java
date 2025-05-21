package com.example.pagination.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.model.User;
import com.example.pagination.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUserList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User updateUser(User user, Long userId) {
		User userDb = userRepository.findById(userId).get();
		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			userDb.setName(user.getName());
		}
		if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			userDb.setEmail(user.getEmail());
		}

		return userRepository.save(userDb);
	}

	@Override
	public void deleteUserById(Long UserId) {
		userRepository.deleteById(UserId);

	}

	@Override
	public Page<User> getUsersWithPaginationAndSorting(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);
		return userRepository.findAll(pageable);
	}
}
