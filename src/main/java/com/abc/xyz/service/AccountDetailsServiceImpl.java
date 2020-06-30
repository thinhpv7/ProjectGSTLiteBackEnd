package com.abc.xyz.service;

//import com.grokonez.jwtauthentication.model.User;
//import com.grokonez.jwtauthentication.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.xyz.entity.Account;
import com.abc.xyz.repository.AccountRepository;
 
@Service
public class AccountDetailsServiceImpl implements UserDetailsService  {
 
  @Autowired
  AccountRepository accountRepository;
 
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    Account account = accountRepository.findByAccountname(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
 
    return AccountPrinciple.build(account);
  }
}