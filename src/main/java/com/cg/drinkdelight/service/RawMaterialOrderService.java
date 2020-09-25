package com.cg.drinkdelight.service;

public interface RawMaterialOrderService {
	public void rawToFinished(long quantityNeeded,String neededProduct);
	public void placeRawMaterialOrder(long rawMatQuantity,String rawMatName);
}
