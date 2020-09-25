package com.cg.drinkdelight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkdelight.dao.ProductOrderDao;
import com.cg.drinkdelight.dao.ProductStockDao;
import com.cg.drinkdelight.entity.ProductOrderEntity;
import com.cg.drinkdelight.entity.ProductStockEntity;
import com.cg.drinkdelight.model.ProductOrderModel;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
	 @Autowired
	 ProductOrderDao productOrderRepo;
	 @Autowired 
	 ProductStockDao productStockRepo;
	private ProductOrderEntity convertProductOrder(ProductOrderModel model) {
		ProductOrderEntity entity = null;
		if (model != null) {
			entity = new ProductOrderEntity();
			entity.setOrderId(model.getOrderId());
			entity.setProductId(model.getProductId());
			entity.setProductName(model.getProductName());
			entity.setDateOfOrder(model.getDateOfOrder());
			entity.setExpectedDeliveryDate(model.getExpectedDeliveryDate());
			entity.setDistributorId(model.getDistributorId());
			entity.setPricePerUnit(model.getPricePerUnit());
			entity.setTotalPrice(model.getTotalPrice());
			entity.setDeliveryStatus(model.getDeliveryStatus());
			entity.setQuantity(model.getQuantity());
		}
		return entity;
	}

	private ProductOrderModel convertProductOrder(ProductOrderEntity entity) {
		ProductOrderModel model = null;
		if (entity != null) {
			model = new ProductOrderModel();
			model.setOrderId(entity.getOrderId());
			model.setProductId(entity.getProductId());
			model.setProductName(entity.getProductName());
			model.setDateOfOrder(entity.getDateOfOrder());
			model.setExpectedDeliveryDate(entity.getExpectedDeliveryDate());
			model.setDistributorId(entity.getDistributorId());
			model.setPricePerUnit(entity.getPricePerUnit());
			model.setTotalPrice(entity.getTotalPrice());
			model.setDeliveryStatus(entity.getDeliveryStatus());
			model.setQuantity(entity.getQuantity());

		}
		return model;
	}
	@Override
	public  ProductOrderModel confirmOrder(ProductOrderModel productModel) {
		ProductOrderModel result=null;
		ProductStockEntity pEntity=new ProductStockEntity();
        long productId=productModel.getProductId();
        if(pEntity.getProductId()==productId) {
        if(pEntity.getProductQuantity() >= productModel.getQuantity()) {
        pEntity.setProductQuantity(pEntity.getProductQuantity()-productModel.getQuantity());
        productStockRepo.save(pEntity);
        result=convertProductOrder(productOrderRepo.
        		save(convertProductOrder(productModel)));
        }
        // pEntity is for Stock
        else if(pEntity.getProductQuantity() < productModel.getQuantity() 
        		&& pEntity.getProductQuantity()!=0) {
        	long quantityNeeded=productModel.getQuantity()-pEntity.getProductQuantity();
        	
        }
        else if(pEntity.getProductQuantity()==0)
        {
        	//"Sorry we are Out of Stock......Exception "
        }
        }
        else {//"Product is incorrect";
        	}
        
        return result;
	}

}
