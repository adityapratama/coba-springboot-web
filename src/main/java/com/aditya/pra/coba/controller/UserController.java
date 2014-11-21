package com.aditya.pra.coba.controller;


import java.net.URI;

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
import org.springframework.web.util.UriTemplate;
import org.springframework.http.HttpStatus;

import com.aditya.pra.coba.domain.User;
import com.aditya.pra.coba.service.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public Page<User> all(Pageable pageable){
		return this.userRepository.findAll(pageable);
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		System.out.println("Save");
		userRepository.save(user);
        Long newId = user.getId();
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, newId);
        response.setHeader("Location", uri.toASCIIString());
    }
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody User user){
		User u = this.userRepository.findOne(id);
		
		if(u == null){
			throw new IllegalStateException("No object with id "+id);
		}
		
		/*u.setId(id);*/
		
		this.userRepository.save(user);
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		this.userRepository.delete(id);
	}
}
