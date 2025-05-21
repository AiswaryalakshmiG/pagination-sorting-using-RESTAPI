package com.example.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.model.User;
import com.example.pagination.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public User saveUser( @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping
	public List<User> getUserList(){
		return userService.getUserList();
		}
	
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") Long userId) {
	    return userService.updateUser(user,userId);
	}

	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id") Long userId) {
	    userService.deleteUserById(userId);
	    return "Deleted Successfully";
	}
	
	@GetMapping("/pagination")
    public Page<User> getUsersWithPaginationAndSorting(
            @RequestParam(defaultValue = "1") int page, 
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy, 
            @RequestParam(defaultValue = "asc") String sortDir) {

       
        return userService.getUsersWithPaginationAndSorting( page, size, sortBy, sortDir);
    }

}
