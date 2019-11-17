package com.pmservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.dao.UserRepository;
import com.pmservice.models.User;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/hello")
	public @ResponseBody String getHelloMsg() {
		return "Hello";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/getByUserId/{userid}")
	public @ResponseBody Optional<User> getByUserId(@PathVariable("userid") Integer userid)
	{
		return userRepository.findById(userid);
	}
	
	@PostMapping(path="/addUser")
	public @ResponseBody String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "Added User Successfully !";
	}
	
	@PutMapping(path="/updateUser")
	public @ResponseBody String updateUser(@RequestBody User user) {
		userRepository.save(user);
		return "Updated Successfully !";
	}
	
	@DeleteMapping(path="/deleteUser/{userid}")
	public @ResponseBody String deleteUser(@PathVariable("userid") Integer userid) {
		userRepository.deleteById(userid);
		return "Deleted Successfully !";
	}
}
