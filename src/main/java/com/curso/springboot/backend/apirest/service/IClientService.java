package com.curso.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.springboot.backend.apirest.entity.Client;
import com.curso.springboot.backend.apirest.entity.Invoice;
import com.curso.springboot.backend.apirest.entity.Product;
import com.curso.springboot.backend.apirest.entity.Region;

public interface IClientService {
	
	public List<Client> findAll();
	
	public Page<Client> findAll(Pageable pageable);
	
	public Client findById(Long id);
	
	public String findByEmail(String email);
	
	public Client save(Client client);
	
	public void delete(Long id);
	
	public List<Region> findAllRegions();
	
	public Invoice findInvoiceById(Long id);
	
	public Invoice saveInvoice(Invoice invoice);
	
	public void deleteInvoiceById(Long id);
	
	public List<Product> findProductByName(String term);

}
