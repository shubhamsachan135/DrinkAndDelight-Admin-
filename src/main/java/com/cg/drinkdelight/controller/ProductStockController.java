package com.cg.drinkdelight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.drinkdelight.dao.ProductStockDao;
import com.cg.drinkdelight.entity.ProductStockEntity;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.service.ProductOrderServiceImpl;

@RestController
@RequestMapping("/saveProduct")
public class ProductStockController {
	@Autowired
	ProductStockDao pStockDao;
	@Autowired
	ProductOrderServiceImpl pOrderService;

	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody ProductStockEntity productEntity)
			throws ProductOrderException {
		String message = pOrderService.saveProduct(productEntity);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/trackProductStock")
	public ResponseEntity<List<ProductStockEntity>> trackProductOrder() {
		List<ProductStockEntity> productList = null;

		productList = pOrderService.trackProductStock();

		return new ResponseEntity<>(productList, HttpStatus.OK);

	}

}
