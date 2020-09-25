package com.cg.drinkdelight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStockEntity {
	@Id
	@Column(name = "product_id", nullable = false) 
	private long productId;
	@Column(name = "quantity", nullable = false)
	private long productQuantity;
	@Column(name = "product_name", nullable = false)
	private String productName;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
