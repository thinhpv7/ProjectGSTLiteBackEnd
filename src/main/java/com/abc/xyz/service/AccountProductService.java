package com.abc.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abc.xyz.entity.AccountProduct;
import com.abc.xyz.repository.AccountProductRepository;


@Service
public class AccountProductService {

	@Autowired
	AccountProductRepository accountProductRepository;
	
	public List<AccountProduct> getAll() {
        return (List<AccountProduct>) accountProductRepository.findAll();
    }
	
	public AccountProduct createAccountProduct(AccountProduct accountproduct) {
        return accountProductRepository.save(accountproduct);
    }
}
