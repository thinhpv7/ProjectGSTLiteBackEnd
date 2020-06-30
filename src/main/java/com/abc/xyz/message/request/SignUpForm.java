package com.abc.xyz.message.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String accountname;
 
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAccountname() {
        return accountname;
    }
 
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}