package com.pmservice.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.dao.TaskRepository;
import com.pmservice.models.ResultData;
import com.pmservice.models.Task;

@RestController
@RequestMapping(path="/task")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getAllTasks", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Iterable<Task>> getAllTasks() {
		return ResponseEntity.ok().body(taskRepository.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByTaskId/{taskid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Optional<Task>> getByTaskId(@PathVariable("taskid") Integer taskid)
	{
		return new ResponseEntity<Optional<Task>>(taskRepository.findById(taskid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByProjectId/{projectid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Task>> getByProjectId(@PathVariable("projectid") Integer projectid)
	{
		return new ResponseEntity<List<Task>>(taskRepository.findByProjectid(projectid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/saveTask", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task savedTask = taskRepository.save(task);
		return ResponseEntity.ok().body(savedTask);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/deleteTask/{taskid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> deleteTask(@PathVariable("taskid") Integer taskid) {
		taskRepository.deleteById(taskid);
		ResultData resultData = new ResultData("Deleted Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
}
