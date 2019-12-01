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

import com.pmservice.dao.ProjectRepository;
import com.pmservice.models.Project;
import com.pmservice.models.ResultData;

@RestController
@RequestMapping(path="/project")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getAllProjects", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Iterable<Project>> getAllProjects() {
		return ResponseEntity.ok().body(projectRepository.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getByProjectId/{projectid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Optional<Project>> getByProjectId(@PathVariable("projectid") Integer projectid)
	{
		return new ResponseEntity<Optional<Project>>(projectRepository.findById(projectid), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/saveProject", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Project> saveProject(@RequestBody Project project) {
		Project savedProject = projectRepository.save(project);
		return ResponseEntity.ok().body(savedProject);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/addProject", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> addProject(@RequestBody Project project) {
		projectRepository.save(project);
		ResultData resultData = new ResultData("Added Project Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/updateProject", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> updateProject(@RequestBody Project project) {
		projectRepository.save(project);
		ResultData resultData = new ResultData("Updated Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/deleteProject/{projectid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultData> deleteProject(@PathVariable("projectid") Integer projectid) {
		projectRepository.deleteById(projectid);
		ResultData resultData = new ResultData("Deleted Successfully !");
		return ResponseEntity.ok().body(resultData);
	}
}
