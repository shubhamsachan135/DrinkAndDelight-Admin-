package com.cg.drinkdelight.service;

import java.util.List;
import com.cg.drinkdelight.entity.ProductStockEntity;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.ProductOrderModel;

public interface ProductOrderService {
	 ProductOrderModel confirmOrder(ProductOrderModel productModel) throws ProductOrderException;
	 List<ProductOrderModel> trackProductOrder(long id) throws ProductOrderException;
	 public String updateProductOrder(ProductOrderModel pOrderModel) throws ProductOrderException;
	 public List<ProductStockEntity> trackProductStock();
	 public String saveProduct(ProductStockEntity productStockEntity) throws ProductOrderException;
	
}
