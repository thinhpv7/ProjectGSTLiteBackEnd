package com.abc.xyz.service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductImageService {
	private final Path root = Paths.get("uploads");


	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }

	  
	  public void save(MultipartFile file) {
	    try {
	    	//Getting the current date
	        Date date = new Date();
	        //This method returns the time in millis
	        long timeMilli = date.getTime();
	        Files.copy(file.getInputStream(), this.root.resolve(timeMilli+file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }

	 
	  public Resource load(String filename) {
	    try {
	    	Path file = root.resolve(filename);
	        Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	 
	  public void deleteAll() {
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  
	  public Stream<Path> loadAll() {
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }

}
