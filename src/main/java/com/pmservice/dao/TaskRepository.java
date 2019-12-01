package com.pmservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.pmservice.models.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
}
