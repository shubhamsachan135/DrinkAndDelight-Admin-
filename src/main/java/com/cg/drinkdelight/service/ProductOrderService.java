package com.cg.drinkdelight.service;

import java.util.List;

import com.cg.drinkdelight.entity.DeliveryStatus;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.ProductOrderModel;

public interface ProductOrderService {
	 ProductOrderModel confirmOrder(ProductOrderModel productModel) throws ProductOrderException;
	//String updateProductOrder(long orderId,DeliveryStatus status);
	//List<ProductOrderModel> trackProductOrder(long id);
	//boolean doesProductOrderIdExists(long id);
	//List<ProductOrderModel> trackProductOrder(long id, DeliveryStatus deliveryStatus);
	
}
