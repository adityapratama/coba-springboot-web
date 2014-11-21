package com.aditya.pra.coba.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.aditya.pra.coba.domain.Permission;
import com.aditya.pra.coba.service.PermissionRepository;

@RestController
@RequestMapping("/api")
public class PermissionController {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@RequestMapping(value="/permission",method=RequestMethod.GET)
	public Page<Permission> all(Pageable pageable){
		return this.permissionRepository.findAll(pageable);
	}
	
	@RequestMapping(value="/permission/{id}",method=RequestMethod.GET)
	public Permission findById(@PathVariable Long id){
		return this.permissionRepository.findOne(id);
	}
	
	@RequestMapping(value="/permission", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Permission permission, HttpServletRequest request, HttpServletResponse response){
		permissionRepository.save(permission);
    }
	
	@RequestMapping(value="/permission/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Permission permission){
		Permission p = this.permissionRepository.findOne(id);
		
		if(p == null){
			throw new IllegalStateException("No object with id "+id);
		}
		
		this.permissionRepository.save(permission);
	}
	
	@RequestMapping(value="/permission/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		this.permissionRepository.delete(id);
	}
}
