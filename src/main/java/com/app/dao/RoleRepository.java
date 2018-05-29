package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AppRole;



public interface RoleRepository extends JpaRepository<AppRole,Long> {
	
public AppRole findByRoleName(String roleName);

}
