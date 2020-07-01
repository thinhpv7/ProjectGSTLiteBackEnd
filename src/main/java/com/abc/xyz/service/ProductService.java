package com.abc.xyz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abc.xyz.entity.Category;
import com.abc.xyz.entity.Product;
import com.abc.xyz.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
     
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public int saveImage(Product model) {
        try {
        	productRepository.save(model);
            return 1;
        } catch (Exception e) {
//            logger.error("ERROR", e);
            return 0;
        }
    }
    
    public Product updateProduct(int Id, Product product){
    	Product updatedCN;
	    Optional<Product> searchEntity = productRepository.findById(Id);
	    if (searchEntity.isPresent()) {
	    	Product cn = searchEntity.get();
	    	cn.setName(product.getName());
	    	cn.setPrice(product.getPrice());
	    	cn.setDescription(product.getDescription());
	    	cn.setCATEGORY_ID(product.getCATEGORY_ID());
	    	cn.setProduct_code(product.getProduct_code());
	        updatedCN = productRepository.save(cn);
	     } else {
	         throw new EntityNotFoundException();
	     }
	     return updatedCN;
    }
    
    public ResponseEntity<Object> deleteProduct(int Id) {
      Optional<Product> product = productRepository.findById(Id);
      if (product.isPresent()) {
    	  Product cn = product.get();
    	  productRepository.delete(cn);
       } else {
              throw new EntityNotFoundException();
       }
       return ResponseEntity.ok().build();
    }
    
    public Optional<Product> detailProduct(int Id) {
        Optional<Product> product = productRepository.findById(Id);
//        if (product.isPresent()) {
//      	  Product cn = product.get();
//      	  productRepository.delete(cn);
//         } else {
//                throw new EntityNotFoundException();
//         }
         return product;
      }

}
