package com.abc.xyz.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
//import javax.annotation.Resource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import java.util.Arrays;
import java.util.List;
import com.abc.xyz.service.ProductImageService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.abc.xyz.entity.ProductImage;
import com.abc.xyz.message.response.ResponseMesssage;

//import antlr.collections.List;
//import io.jsonwebtoken.lang.Arrays;

@Controller
@CrossOrigin("http://localhost:8081")
public class ProductImageController {
	@Autowired
	 ProductImageService storageService;
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMesssage> uploadFiles(@RequestParam("files") MultipartFile[] files) {
	    String message = "";
	    try {
	    	List<String> fileNames = new ArrayList<>();

	    	Arrays.asList(files).stream().forEach(file -> {
	        storageService.save(file);
	        fileNames.add(file.getOriginalFilename());
	      });

	      message = "Uploaded the files successfully: " + fileNames;
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMesssage(message));
	    } catch (Exception e) {
	    	System.out.print(e);
	      message = "Fail to upload files!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMesssage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ProductImage>> getListFiles() {
	    List<ProductImage> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(ProductImageController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new ProductImage(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }

	  @GetMapping("/files/{filename:.+}")
	  public ResponseEntity<Resource> getFile(@PathVariable(value = "filename") String filename){
	    Resource file = storageService.load(filename);
	    ClassPathResource imageFile = new ClassPathResource("http://localhost/8080/" + file.getFilename());
//
//		byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());
//
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
//	    return ResponseEntity.ok()
//	        .header(HttpHeaders.CONTENT_DISPOSITION, "read; filename=\"" + file.getFilename() + "\"").body(file);
	  }

}
