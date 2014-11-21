package com.aditya.pra.coba.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.aditya.pra.coba.domain.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	List<Person> findByLastName(@Param("name") String name);
}
