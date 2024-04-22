package com.curso.springboot.backend.apirest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource upload(String namePhoto) throws MalformedURLException;
	
	public String copy(MultipartFile file) throws IOException;
	
	public Boolean delete(String namePhoto);
	
	public Path getPath(String namePhoto);
}
