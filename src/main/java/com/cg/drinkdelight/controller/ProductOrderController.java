package com.cg.drinkdelight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.ProductOrderModel;
import com.cg.drinkdelight.service.ProductOrderServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductOrderController {
	@Autowired
	ProductOrderServiceImpl pOrderService;
	@PostMapping
	public  ResponseEntity<ProductOrderModel> confirmOrder(@RequestBody ProductOrderModel productOrderModel) throws ProductOrderException
	{
		 productOrderModel=pOrderService.confirmOrder(productOrderModel);
		
		return new ResponseEntity<>(productOrderModel,HttpStatus.CREATED);
	}
	
}
