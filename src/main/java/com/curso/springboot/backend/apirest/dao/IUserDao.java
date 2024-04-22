package com.curso.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.backend.apirest.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);

}
