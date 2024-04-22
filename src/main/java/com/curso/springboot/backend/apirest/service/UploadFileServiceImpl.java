package com.curso.springboot.backend.apirest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService{
	
	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

	private final static String PATH_UPLOAD = "uploads";
	@Override
	public Resource upload(String namePhoto) throws MalformedURLException {
		Path pathFile = getPath(namePhoto);
		log.info(pathFile.toString());
		Resource resource = new UrlResource(pathFile.toUri());
		
		if(!resource.exists() && !resource.isReadable()) {
			pathFile = Paths.get("src/main/resources/static/images/imagen.png").resolve(namePhoto).toAbsolutePath();
			resource = new UrlResource(pathFile.toUri());
			log.error("Error, no se pudo cargar la imagen: " + namePhoto);
		}
		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
		//String nameFile = file.getOriginalFilename().replace(" ", "");
		Path pathFile = getPath(nameFile);
		log.info(pathFile.toString());
		
		Files.copy(file.getInputStream(), pathFile);
		return nameFile;
	}

	@Override
	public Boolean delete(String namePhoto) {
		if(namePhoto != null && namePhoto.length() > 0) {
			Path pathLastFile = Paths.get("uploads").resolve(namePhoto).toAbsolutePath();
			java.io.File fileLastPhoto = pathLastFile.toFile();
			if(fileLastPhoto.exists() && fileLastPhoto.canRead()) {
				fileLastPhoto.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String namePhoto) {
		return Paths.get(PATH_UPLOAD).resolve(namePhoto).toAbsolutePath();
	}

}
