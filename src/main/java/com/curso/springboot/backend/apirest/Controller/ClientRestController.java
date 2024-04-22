package com.curso.springboot.backend.apirest.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.curso.springboot.backend.apirest.entity.Client;
import com.curso.springboot.backend.apirest.entity.Region;
import com.curso.springboot.backend.apirest.service.IClientService;
import com.curso.springboot.backend.apirest.service.IUploadFileService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	private final Logger log = LoggerFactory.getLogger(ClientRestController.class);
	
	@GetMapping("/clients")
	public List<Client> index() {
		return clientService.findAll();
	}
	
	@GetMapping("/clients/page/{page}")
	public Page<Client> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return clientService.findAll(pageable);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/clients/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Client client = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			client = clientService.findById(id);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(client == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no ha sido encontrado!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping("/clients/email")
	public ResponseEntity<?> email(@RequestBody String email) {
		
		String clientEmail = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			clientEmail = clientService.findByEmail(email);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(clientEmail == null) {
			response.put("mensaje", "El cliente ID: ".concat(email.toString().concat(" no ha sido encontrado!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		response.put("mensaje", "El email " + clientEmail + " está en uso");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Client client, BindingResult result) {
		
		Client newClient = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
//			List<String> errors = new ArrayList<>();
//			for(FieldError error: result.getFieldErrors()) {
//				errors.add("El campo" + error.getField() + " " + error.getDefaultMessage());
//			}
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			newClient = clientService.save(client);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado correctamente");
		response.put("Cliente", newClient);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/clients/{id}")
	public ResponseEntity<?> update(@RequestBody Client client, BindingResult result, @PathVariable Long id) {
		
		Client currentClient = clientService.findById(id);
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
//			List<String> errors = new ArrayList<>();
//			for(FieldError error: result.getFieldErrors()) {
//				errors.add("El campo" + error.getField() + " " + error.getDefaultMessage());
//			}
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(currentClient == null) {
			response.put("mensaje", "Error: no se pudo editar el cliente ID: ".concat(id.toString().concat(" no ha sido encontrado!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			currentClient.setName(client.getName());
			currentClient.setEmail(client.getEmail());
			currentClient.setSurname(client.getSurname());
			currentClient.setRegion(client.getRegion());
			
			clientService.save(currentClient);
		} catch (Exception e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizado correctamente");
		response.put("Cliente", currentClient);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("clients/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Client client = clientService.findById(id);
			String nameLastPhoto = client.getPhoto();
			
			uploadService.delete(nameLastPhoto);
			
			clientService.delete(id);
		} catch (Exception e) {
			response.put("mensaje", "Error al eliminar el cliente en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El cliente ha sido eliminado correctamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("clients/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Client client = clientService.findById(id);
		
		if(!file.isEmpty()) {
			log.debug("file is not null");
			String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
			try {
				log.info(uploadService.copy(file));
				nameFile = uploadService.copy(file);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen ");
				response.put("Error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nameLastPhoto = client.getPhoto();
			
			uploadService.delete(nameLastPhoto);
			
			client.setPhoto(nameFile);
			
			clientService.save(client);
			
			response.put("client", client);
			response.put("mensaje", "Imagen subida correctamente: " + nameFile);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("uploads/img/{namePhoto:.+}")
	public ResponseEntity<Resource> showPhoto(@PathVariable String namePhoto) {
		
		Resource resource = null;
		
		try {
			resource = uploadService.upload(namePhoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@GetMapping("clients/regions")
	public List<Region> listRegions() {
		return clientService.findAllRegions();
	}

}
