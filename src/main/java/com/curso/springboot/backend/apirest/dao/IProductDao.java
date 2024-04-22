package com.curso.springboot.backend.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.backend.apirest.entity.Product;

public interface IProductDao extends CrudRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.name like %?1%")
	public List<Product> findByName(String term);
	
	public List<Product> findByNameContainingIgnoreCase(String term);
	
	public List<Product> findByNameStartingWithIgnoreCase(String term);

}
