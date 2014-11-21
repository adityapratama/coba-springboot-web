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

import com.aditya.pra.coba.domain.Menu;
import com.aditya.pra.coba.service.MenuRepository;

@RestController
@RequestMapping("/api")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public Page<Menu> all(Pageable pageable){
		return this.menuRepository.findAll(pageable);
	}
	
	@RequestMapping(value="/menu/{id}",method=RequestMethod.GET)
	public Menu findById(@PathVariable Long id){
		return this.menuRepository.findOne(id);
	}
	
	@RequestMapping(value="/menu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Menu menu){
		menuRepository.save(menu);
    }
	
	@RequestMapping(value="/menu/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Menu menu){
		Menu m = this.menuRepository.findOne(id);
		
		if(m == null){
			throw new IllegalStateException("No object with id "+id);
		}
		
		/*u.setId(id);*/
		
		this.menuRepository.save(menu);
	}
	
	@RequestMapping(value="/menu/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		this.menuRepository.delete(id);
	}
}
