package com.pmservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.pmservice.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
}
