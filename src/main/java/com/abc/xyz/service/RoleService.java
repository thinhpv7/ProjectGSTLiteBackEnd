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

import com.abc.xyz.entity.Product;
import com.abc.xyz.entity.Role;
import com.abc.xyz.repository.ProductRepository;
import com.abc.xyz.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }
     
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    
    
    public Role updateRole(Long Id, Role role){
    	Role updatedCN;
	    Optional<Role> searchEntity = roleRepository.findById(Id);
	    if (searchEntity.isPresent()) {
	    	Role cn = searchEntity.get();
	    	cn.setName(role.getName());
	        updatedCN = roleRepository.save(cn);
	     } else {
	         throw new EntityNotFoundException();
	     }
	     return updatedCN;
    }
    
    public ResponseEntity<Object> deleteRole(Long Id) {
	    Optional<Role> role = roleRepository.findById(Id);
	    if (role.isPresent()) {
	  	  Role cn = role.get();
	  	roleRepository.delete(cn);
	     } else {
	            throw new EntityNotFoundException();
	     }
	     return ResponseEntity.ok().build();
	 }

}
