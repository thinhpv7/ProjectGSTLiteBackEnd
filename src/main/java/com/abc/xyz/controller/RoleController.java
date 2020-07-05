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
import com.abc.xyz.entity.Role;
import com.abc.xyz.service.CategoryService;
import com.abc.xyz.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;
	@RequestMapping(value = "/role_all")
    public List<Role> role() {
        return roleService.getAll();
    }
 
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Role createCategory(@Valid @RequestBody Role role)
    {
        return roleService.createRole(role);
    }
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Long id) 
    {
        return roleService.deleteRole(id);
    }
 
    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public Role updateRole(@PathVariable(value = "id") Long id, @Valid @RequestBody Role role) 
    {
        return roleService.updateRole(id, role);
    }
}
