package com.cg.drinkdelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drinkdelight.entity.ProductOrderEntity;
import com.cg.drinkdelight.entity.SupplierEntity;

@Repository
public interface SupplierDao extends JpaRepository<SupplierEntity,Long>{
	
	
}
