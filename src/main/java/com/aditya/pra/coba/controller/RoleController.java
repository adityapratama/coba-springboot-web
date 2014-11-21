package com.aditya.pra.coba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.aditya.pra.coba.domain.Role;
import com.aditya.pra.coba.service.RoleRepository;

@RestController
@RequestMapping("/api")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/role",method=RequestMethod.GET)
	public Page<Role> all(Pageable pageable){
		return this.roleRepository.findAll(pageable);
	}
	
	@RequestMapping(value="/role/{id}",method=RequestMethod.GET)
	public Role findById(@PathVariable Long id){
		return this.roleRepository.findOne(id);
	}
	
	@RequestMapping(value="/role", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Role role){
		roleRepository.save(role);
    }
	
	@RequestMapping(value="/role/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Role role){
		Role r = this.roleRepository.findOne(id);
		
		if(r == null){
			throw new IllegalStateException("No object with id "+id);
		}
		
		/*u.setId(id);*/
		
		this.roleRepository.save(role);
	}
	
	@RequestMapping(value="/role/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		this.roleRepository.delete(id);
	}
}
