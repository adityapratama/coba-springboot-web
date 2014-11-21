package com.aditya.pra.coba.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aditya.pra.coba.domain.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
}
