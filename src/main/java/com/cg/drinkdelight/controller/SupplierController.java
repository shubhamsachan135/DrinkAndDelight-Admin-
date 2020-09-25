package com.cg.drinkdelight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkdelight.dao.SupplierDao;
import com.cg.drinkdelight.entity.RawMaterialStockEntity;
import com.cg.drinkdelight.entity.SupplierEntity;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierDao suppDao;
	@GetMapping
	public void saveSupplier() {
	ArrayList<RawMaterialStockEntity> rList1=new ArrayList<RawMaterialStockEntity>();
	rList1.add(new RawMaterialStockEntity(101,1000,"Mango"));
	rList1.add(new RawMaterialStockEntity(102,1000,"Apple"));
	rList1.add(new RawMaterialStockEntity(103,1000,"Kiwi"));
	SupplierEntity suppEntity1=new SupplierEntity(501,"Shubham",rList1);
	suppDao.save(suppEntity1);
	
	ArrayList<RawMaterialStockEntity> rList2=new ArrayList<RawMaterialStockEntity>();
	rList2.add(new RawMaterialStockEntity(201,1000,"Mango"));
	rList2.add(new RawMaterialStockEntity(202,1000,"Apple"));
	rList2.add(new RawMaterialStockEntity(203,1000,"Orange"));
	SupplierEntity suppEntity2=new SupplierEntity(601,"Utkarsh",rList2);
	suppDao.save(suppEntity2);
	
	ArrayList<RawMaterialStockEntity> rList3=new ArrayList<RawMaterialStockEntity>();
	rList3.add(new RawMaterialStockEntity(301,1000,"Mango"));
	rList3.add(new RawMaterialStockEntity(302,1000,"PineApple"));
	rList3.add(new RawMaterialStockEntity(303,1000,"Cherry"));
	SupplierEntity suppEntity3=new SupplierEntity(701,"Sudhanshu",rList3);
	suppDao.save(suppEntity3);
	}
}
