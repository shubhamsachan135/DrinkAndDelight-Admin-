package com.cg.drinkdelight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@SequenceGenerator(name="seq", initialValue=10, allocationSize=99)
public class RawMaterialOrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name = "order_id", nullable = false)
	private long orderId;

	@Column(name = "rawmat_Id", nullable = false)
	private long rawMatId;

	@Column(name = "", nullable = false)
	private String rawMatName;

	@Column(name = "distibutor_Id", nullable = false)
	private long supplierId;

	@Column(name = "quantity", nullable = false)
	private long quantity;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "order_date", nullable = false)
	private LocalDate dateOfOrder;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getRawMatId() {
		return rawMatId;
	}

	public void setRawMatId(long rawMatId) {
		this.rawMatId = rawMatId;
	}

	public String getRawMatName() {
		return rawMatName;
	}

	public void setRawMatName(String rawMatName) {
		this.rawMatName = rawMatName;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public RawMaterialOrderEntity() {}
	public RawMaterialOrderEntity(long rawMatId, String rawMatName, long supplierId, long quantity,
			LocalDate dateOfOrder) {
		super();
	//	this.orderId = orderId;
		this.rawMatId = rawMatId;
		this.rawMatName = rawMatName;
		this.supplierId = supplierId;
		this.quantity = quantity;
		this.dateOfOrder = dateOfOrder;
	}
	
}
