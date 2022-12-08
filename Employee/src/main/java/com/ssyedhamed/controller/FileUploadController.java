package com.ssyedhamed.controller;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ssyedhamed.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException{
		if(!file.getContentType().equals("image/jpeg")&&!file.getContentType().equals("image/png")) {
			System.out.println(file.getContentType());
			return new ResponseEntity<String>("File not supported, Should be of jpeg type", HttpStatus.BAD_REQUEST);
		}
		if(file.isEmpty()) {
			return new ResponseEntity<String>("File is empty", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//file upload
		boolean f=fileUploadHelper.uploadFile(file);
		if(f) {
			return new ResponseEntity<String>(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString(), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
