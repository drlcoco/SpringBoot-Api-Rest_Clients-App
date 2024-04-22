package com.curso.springboot.backend.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.springboot.backend.apirest.entity.Client;
import com.curso.springboot.backend.apirest.entity.Region;

public interface IClientDao extends JpaRepository<Client, Long>{
	
	@Query("SELECT c.email FROM Client c WHERE c.email = ?1")
    String findByEmail(String email);
	
	@Query("SELECT r FROM Region r")
	public List<Region> findAllRegions();

}
