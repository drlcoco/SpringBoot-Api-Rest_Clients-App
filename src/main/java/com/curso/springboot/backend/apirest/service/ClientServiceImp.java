package com.curso.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.springboot.backend.apirest.dao.IClientDao;
import com.curso.springboot.backend.apirest.dao.IInvoiceDao;
import com.curso.springboot.backend.apirest.dao.IProductDao;
import com.curso.springboot.backend.apirest.entity.Client;
import com.curso.springboot.backend.apirest.entity.Invoice;
import com.curso.springboot.backend.apirest.entity.Product;
import com.curso.springboot.backend.apirest.entity.Region;

@Service
public class ClientServiceImp implements IClientService{

	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IInvoiceDao invoiceDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Client> findAll(Pageable pageable) {
		return clientDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Client findById(Long id) {
		return clientDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=true)
	public String findByEmail(String email) {
		return clientDao.findByEmail(email);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		return clientDao.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Region> findAllRegions() {
		return clientDao.findAllRegions();
	}

	@Override
	@Transactional(readOnly=true)
	public Invoice findInvoiceById(Long id) {
		return invoiceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceDao.save(invoice);
	}

	@Override
	@Transactional
	public void deleteInvoiceById(Long id) {
		invoiceDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> findProductByName(String term) {
		return productDao.findByNameContainingIgnoreCase(term);
	}

}
