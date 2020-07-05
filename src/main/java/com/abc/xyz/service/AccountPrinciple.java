package com.abc.xyz.service;

import org.springframework.beans.factory.annotation.Autowired;
//import com.grokonez.jwtauthentication.model.User;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.abc.xyz.entity.Account;
import com.abc.xyz.entity.Product;
import com.abc.xyz.repository.AccountRepository;
import com.abc.xyz.repository.RoleRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
 
public class AccountPrinciple implements UserDetails {
  private static final long serialVersionUID = 1L;
 
 
  private Long id;
 
    private String name;
 
    private String accountname;
 
    private String email;
 
    @JsonIgnore
    private String password;
 
    private Collection<? extends GrantedAuthority> authorities;
 
    public AccountPrinciple(Long id, String name, 
              String accountname, String email, String password, 
              Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.accountname = accountname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
 
    public static AccountPrinciple build(Account account) {
        List<GrantedAuthority> authorities = account.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new AccountPrinciple(
        		account.getId(),
        		account.getName(),
        		account.getAccountname(),
        		account.getEmail(),
        		account.getPassword(),
                authorities
        );
    }
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public String getAccountname() {
        return accountname;
    }
    
    @Override
    public String getUsername() {
        return accountname;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AccountPrinciple user = (AccountPrinciple) o;
        return Objects.equals(id, user.id);
    }
    
    
}