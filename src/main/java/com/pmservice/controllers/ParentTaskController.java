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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.dao.ParentTaskRepository;
import com.pmservice.models.ParentTask;
import com.pmservice.models.ResultData;

@RestController
@RequestMapping(path="/parentTask")
public class ParentTaskController {

	@Autowired
	private ParentTaskRepository parentTaskRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getAllParentTasks", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Iterable<ParentTask>> getAllParentTasks() {
		return ResponseEntity.ok().body(parentTaskRepository.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByParentTaskId/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Optional<ParentTask>> getByParentTaskId(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<Optional<ParentTask>>(parentTaskRepository.findById(id), HttpStatus.OK);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/saveParentTask", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ParentTask> saveParentTask(@RequestBody ParentTask parentTask) {
		ParentTask savedParentTask = parentTaskRepository.save(parentTask);
		return ResponseEntity.ok().body(savedParentTask);
	}
			
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/deleteParentTask/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> deleteParentTask(@PathVariable("id") Integer id) {
		parentTaskRepository.deleteById(id);
		ResultData resultData = new ResultData("Deleted Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
}
