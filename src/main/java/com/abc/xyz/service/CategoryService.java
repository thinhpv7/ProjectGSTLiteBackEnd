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
import com.abc.xyz.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }
     
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
     
    public Category updateCategory(int Id, Category category){
		Category updatedCN;
	    Optional<Category> searchEntity = categoryRepository.findById(Id);
	    if (searchEntity.isPresent()) {
	    	Category cn = searchEntity.get();
	    	cn.setName(category.getName());
	        updatedCN = categoryRepository.save(cn);
	     } else {
	         throw new EntityNotFoundException();
	     }
	     return updatedCN;
    }
    
    public ResponseEntity<Object> deleteCategory(int Id) {
      Optional<Category> category = categoryRepository.findById(Id);
      if (category.isPresent()) {
    	  Category cn = category.get();
    	  categoryRepository.delete(cn);
       } else {
              throw new EntityNotFoundException();
       }
       return ResponseEntity.ok().build();
    }
    
//    public List<Category> getAllCategory(Integer pageNo, Integer pageSize, int id, String sortBy)
//    {
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
// 
//        Page<Category> pagedResult = categoryRepository.findMajor(id,paging);
//         
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<Category>();
//        }
//    }
    
    public List<Category> getAllCategory2(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Category> pagedResult = categoryRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Category>();
        }
    }

}
