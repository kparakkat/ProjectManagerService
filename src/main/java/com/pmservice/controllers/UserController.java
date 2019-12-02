package com.pmservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.pmservice.models.ResultData;
import com.pmservice.models.User;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
		
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getAllUsers", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Iterable<User>> getAllUsers() {
		return ResponseEntity.ok().body(userRepository.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByUserId/{userid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Optional<User>> getByUserId(@PathVariable("userid") Integer userid)
	{
		return new ResponseEntity<Optional<User>>(userRepository.findById(userid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByProjectId/{projectid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> getByProjectId(@PathVariable("projectid") Integer projectid)
	{
		return new ResponseEntity<User>(userRepository.findByProjectid(projectid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByTaskId/{taskid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> getByTaskId(@PathVariable("taskid") Integer taskid)
	{
		return new ResponseEntity<User>(userRepository.findByTaskid(taskid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/addUser", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> addUser(@RequestBody User user) {
		userRepository.save(user);
		ResultData resultData = new ResultData("Added User Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/updateUser", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> updateUser(@RequestBody User user) {
		userRepository.save(user);
		ResultData resultData = new ResultData("Updated Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/deleteUser/{userid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> deleteUser(@PathVariable("userid") Integer userid) {
		userRepository.deleteById(userid);
		ResultData resultData = new ResultData("Deleted Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
}
