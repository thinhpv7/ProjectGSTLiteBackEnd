package com.abc.xyz.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.abc.xyz.entity.Category;
import com.abc.xyz.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/category_all")
    public List<Category> category() {
        return categoryService.getAll();
    }
 
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category createCategory(@Valid @RequestBody Category category)
    {
        return categoryService.createCategory(category);
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") int id) 
    {
        return categoryService.deleteCategory(id);
    }
 
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable(value = "id") int id, @Valid @RequestBody Category category) 
    {
        return categoryService.updateCategory(id, category);
    }
    
//    @RequestMapping(value = "/category2", method = RequestMethod.GET)
//    public ResponseEntity<List<Category>> getAllCategory(
//                        @RequestParam(defaultValue = "0") Integer pageNo,
//                        @RequestParam(defaultValue = "2") Integer pageSize,
//                        @RequestParam(defaultValue = "1") int idChuyennganh,
//                        @RequestParam(defaultValue = "ID") String sortBy)
//    {
//        List<Category> list = categoryService.getAllCategory(pageNo, pageSize, idChuyennganh, sortBy);
// 
//        return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
//    }
    
    @RequestMapping(value = "/chuyennganh3", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory2(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "ID") String sortBy)
    {
        List<Category> list = categoryService.getAllCategory2(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
