package com.abc.xyz.service;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.abc.xyz.entity.ImageProduct;
import com.abc.xyz.repository.ImageProductRepository;

@Service
public class ImageProductService {

	@Autowired
	ImageProductRepository imageProductRepository;
	
	public ImageProduct createProduct(ImageProduct img_product) {
    	System.out.print(img_product.getID());
    	ImageProduct retObject = imageProductRepository.save(img_product );
    	imageProductRepository.flush();
    	System.out.print(retObject.getID());
    	return retObject;
//        return productRepository.save(product);
    }
	
	public ResponseEntity<Object> deleteImageProduct(int Id) 
    {
      Integer cart = imageProductRepository.deleteImageProduct(Id);
      if (cart>0) {
      	System.out.println("Xoa thanh cong!");
       } else {
              throw new EntityNotFoundException();
       }
       return ResponseEntity.ok().build();
    }
}
