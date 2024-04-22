package com.curso.springboot.backend.apirest.service;

import com.curso.springboot.backend.apirest.entity.User;

public interface IUsuarioService {
	
	public User findByUsername(String username);

}
