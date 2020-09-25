package com.cg.drinkdelight.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class RawMaterialStockEntity {
	@Id
	@Column(name = "raw_material_id", nullable = false) 
	private long rawMaterialId;
	@Column(name = "quantity", nullable = false)
	private long rawMaterialQuantity;
	@Column(name = "raw_material_name", nullable = false)
	private String rawMaterialName;
	public long getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(long rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
	public long getRawMaterialQuantity() {
		return rawMaterialQuantity;
	}
	public void setRawMaterialQuantity(long rawMaterialQuantity) {
		this.rawMaterialQuantity = rawMaterialQuantity;
	}
	public String getRawMaterialName() {
		return rawMaterialName;
	}
	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}
	
}
