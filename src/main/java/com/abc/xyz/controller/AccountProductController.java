package com.abc.xyz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
}
