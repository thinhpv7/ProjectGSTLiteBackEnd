package com.abc.xyz.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<Object> updateAccountProduct(int Id, int Id2, AccountProduct acpro)
    {
    	int ktra = accountProductRepository.updateCartProduct(Id, Id2, acpro.getQuantity());
        if (ktra>0) {
        	acpro.setQuantity(acpro.getQuantity());
        	System.out.println(acpro.getQuantity());
         } else {
             throw new EntityNotFoundException();
         }
        return ResponseEntity.ok().build();
       }
	
	public ResponseEntity<Object> deleteCart(int Id, int Id2) 
    {
      Integer cart = accountProductRepository.deleteCartProduct(Id, Id2);
      if (cart>0) {
      	System.out.println("Xoa thanh cong!");
       } else {
              throw new EntityNotFoundException();
       }
       return ResponseEntity.ok().build();
    }
}
