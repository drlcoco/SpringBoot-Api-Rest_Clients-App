package com.curso.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.backend.apirest.entity.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Long>{
	
	

}
