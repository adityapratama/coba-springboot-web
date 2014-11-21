package com.aditya.pra.coba.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

import com.aditya.pra.coba.domain.Menu;

@Repository
public interface MenuRepository extends PagingAndSortingRepository<Menu, Long>{
}
