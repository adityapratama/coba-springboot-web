package com.aditya.pra.coba.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

import com.aditya.pra.coba.domain.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>{
}
