package com.abc.xyz.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.xyz.entity.ImageProduct;
import com.abc.xyz.repository.ImageProductRepository;
import com.abc.xyz.service.ImageProductService;

@RestController
public class ImageProductController {

	@Autowired
	ImageProductService imageProductService;
	ImageProductRepository imageProductRepository;
	
	@RequestMapping(value = "/image_product", method = RequestMethod.POST)
    public ImageProduct createImgProduct(@Valid @RequestBody ImageProduct img_product)
    {
        return imageProductService.createProduct(img_product);
    }
	
	@RequestMapping(value = "/image_product/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCart(@PathVariable(value = "id") int id) 
    {
		return imageProductService.deleteImageProduct(id);
    }
}
