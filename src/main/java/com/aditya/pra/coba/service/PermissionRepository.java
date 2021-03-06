package com.aditya.pra.coba.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

import com.aditya.pra.coba.domain.Permission;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>{
}
