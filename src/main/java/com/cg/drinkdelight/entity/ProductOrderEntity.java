package com.cg.drinkdelight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cg.drinkdelight.entity.DeliveryStatus;
@Entity
public class ProductOrderEntity {
	@Id
	@Column(name = "order_id", nullable = false)
	private long orderId;

	@Column(name = "product_Id", nullable = false)
	private long productId;

	@Column(name = "", nullable = false)
	private String productName;

	@Column(name = "distibutor_Id", nullable = false)
	private long distributorId;

	@Column(name = "quantity", nullable = false)
	private long quantity;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "order_date", nullable = false)
	private LocalDate dateOfOrder;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "delivery_date", nullable = false)
	private LocalDate expectedDeliveryDate;

	@Column(name = "ppu", nullable = false)
	private double pricePerUnit;

	@Column(name = "total_price", nullable = false)
	private double totalPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private DeliveryStatus deliveryStatus;
	
	public ProductOrderEntity() {};
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(long distributorId) {
		this.distributorId = distributorId;
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

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public ProductOrderEntity(long orderId, long productId, String productName, long distributorId, long quantity,
			LocalDate dateOfOrder, LocalDate expectedDeliveryDate, double pricePerUnit, double totalPrice,
			DeliveryStatus deliveryStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.distributorId = distributorId;
		this.quantity = quantity;
		this.dateOfOrder = dateOfOrder;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
		this.deliveryStatus = deliveryStatus;
	}
	

}
