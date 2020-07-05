package com.abc.xyz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.xyz.entity.Account;
import com.abc.xyz.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public Optional<Account> deteilAccount(long Id) {
        Optional<Account> account = accountRepository.findById(Id);
//        if (product.isPresent()) {
//      	  Product cn = product.get();
//      	  productRepository.delete(cn);
//         } else {
//                throw new EntityNotFoundException();
//         }
         return account;
      }

}
