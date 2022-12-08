package com.ssyedhamed.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public  boolean uploadFile(MultipartFile file) throws IOException {
		boolean f=false;
//		String UPLOAD_DIR="C:\\Users\\SYEDS'\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\Employee\\src\\main\\resources\\static\\images";
		String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();
		try {
//			InputStream is = file.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );
			f=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
}
