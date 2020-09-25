package com.cg.drinkdelight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkdelight.dao.ProductStockDao;
import com.cg.drinkdelight.entity.ProductStockEntity;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.ProductOrderModel;

@RestController
@RequestMapping("/saveProduct")
public class ProductStockController {
	@Autowired
	ProductStockDao pStockDao;
	@PostMapping
	public  ResponseEntity<String> confirmOrder(@RequestBody ProductStockEntity productEntity) throws ProductOrderException
	{
		pStockDao.save(productEntity);
		
		return new ResponseEntity<>("Product added to stock successfully",HttpStatus.OK);
	}
}
