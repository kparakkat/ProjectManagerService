package com.pmservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pmservice.models.Task;
import com.pmservice.models.User;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	List<Task> findByProjectid(Integer projectid);
}
