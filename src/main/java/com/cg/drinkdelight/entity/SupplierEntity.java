package com.cg.drinkdelight.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SupplierEntity {
	@Id
	@Column(name = "supplier_id", nullable = false) 
	private long supplierId;
	
	@Column(name = "supplier_name", nullable = false)
	private String supplierName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<RawMaterialStockEntity> rawMaterials;
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public List<RawMaterialStockEntity> getRawMaterials() {
		return rawMaterials;
	}
	public void setRawMaterials(List<RawMaterialStockEntity> rawMaterials) {
		this.rawMaterials = rawMaterials;
	}
	
	
}
