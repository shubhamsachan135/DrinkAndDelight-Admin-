package com.cg.drinkdelight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.drinkdelight.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierService suppService;

	@GetMapping
	public ResponseEntity<String> saveSupplier() {
		suppService.saveSupplier();
		return new ResponseEntity<>("Suppliers Data Saved Successfully", HttpStatus.OK);
	}
}
