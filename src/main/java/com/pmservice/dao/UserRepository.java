package com.pmservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.pmservice.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByProjectid(Integer projectid);
}