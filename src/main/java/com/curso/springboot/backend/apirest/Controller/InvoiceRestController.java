package com.curso.springboot.backend.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.backend.apirest.entity.Invoice;
import com.curso.springboot.backend.apirest.entity.Product;
import com.curso.springboot.backend.apirest.service.IClientService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class InvoiceRestController {
	
	@Autowired
	private IClientService clientService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/invoices/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Invoice show(@PathVariable Long id) {
		return clientService.findInvoiceById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/invoices/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientService.deleteInvoiceById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/invoices/filter-product/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> filterProduct(@PathVariable String term) {
		return clientService.findProductByName(term);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/invoices")
	@ResponseStatus(HttpStatus.CREATED)
	public Invoice save(@RequestBody Invoice invoice) {
		return clientService.saveInvoice(invoice);
	}

}
