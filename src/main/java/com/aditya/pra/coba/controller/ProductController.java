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

import com.aditya.pra.coba.domain.Product;
import com.aditya.pra.coba.service.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public Page<Product> all(Pageable pageable){
		return this.productRepository.findAll(pageable);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public Product findById(@PathVariable Long id){
		return this.productRepository.findOne(id);
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Product product){
		productRepository.save(product);
    }
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Product product){
		Product p = this.productRepository.findOne(id);
		
		if(p == null){
			throw new IllegalStateException("No object with id "+id);
		}
		
		/*u.setId(id);*/
		
		this.productRepository.save(product);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		this.productRepository.delete(id);
	}
}
