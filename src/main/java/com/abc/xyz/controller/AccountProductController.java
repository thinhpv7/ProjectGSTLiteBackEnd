package com.abc.xyz.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.xyz.entity.AccountProduct;
import com.abc.xyz.entity.Category;
import com.abc.xyz.entity.Product;
import com.abc.xyz.repository.ProductRepository;
import com.abc.xyz.service.AccountProductService;
import com.abc.xyz.service.ProductService;


@RestController
public class AccountProductController {
	@Autowired
	AccountProductService accountProductService;
	
	@RequestMapping(value = "/account_product_all")
    public List<AccountProduct> accountProduct() {
        return accountProductService.getAll();
    }
	
	@RequestMapping(value = "/account_product", method = RequestMethod.POST)
    public AccountProduct createAccountProduct(@Valid @RequestBody AccountProduct accountProduct)
    {
        return accountProductService.createAccountProduct(accountProduct);
    }
	
	@RequestMapping(value = "/account_product/{id}/{id2}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAccountProduct(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2, @Valid @RequestBody AccountProduct accpro)
    {
        return accountProductService.updateAccountProduct(id, id2, accpro);
    }
	
	@RequestMapping(value = "/account_product/{id}/{id2}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCart(@PathVariable(value = "id") int id, @PathVariable(value = "id2") int id2) 
    {
		return accountProductService.deleteCart(id, id2);
    }
	
	@RequestMapping(value = "/delete_product/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delelteProduct(@PathVariable(value = "id") int id) 
    {
		return accountProductService.deleteProduct(id);
    }
	
	@RequestMapping(value = "/account_product/{id}/", method = RequestMethod.GET)
    public List<AccountProduct> getCart(@PathVariable(value = "id") int id) 
    {
		return accountProductService.getCart(id);
    }
}
