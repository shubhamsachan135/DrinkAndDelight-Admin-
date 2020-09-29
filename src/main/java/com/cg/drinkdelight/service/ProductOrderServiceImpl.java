package com.cg.drinkdelight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.drinkdelight.dao.ProductOrderDao;
import com.cg.drinkdelight.dao.ProductStockDao;
import com.cg.drinkdelight.entity.ProductOrderEntity;
import com.cg.drinkdelight.entity.ProductStockEntity;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.ProductOrderModel;


@Service
public class ProductOrderServiceImpl implements ProductOrderService {
	@Autowired
	ProductOrderDao productOrderRepo;
	@Autowired
	ProductStockDao productStockRepo;
	@Autowired
	RawMaterialOrderServiceImpl rMatOrderService;

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
	public ProductOrderModel confirmOrder(ProductOrderModel productModel) throws ProductOrderException {
		ProductOrderModel result = null;
		long productId = productModel.getProductId();
		ProductStockEntity pEntity = productStockRepo.findById(productId).orElse(null);
		if (pEntity != null) {
			if (pEntity.getProductQuantity() >= productModel.getQuantity()) {
				pEntity.setProductQuantity(pEntity.getProductQuantity() - productModel.getQuantity());
				productStockRepo.save(pEntity);
				result = convertProductOrder(productOrderRepo.save(convertProductOrder(productModel)));

			}
			// pEntity is for ProductStockEntity
			else if (pEntity.getProductQuantity() < productModel.getQuantity() && pEntity.getProductQuantity() != 0) {
				
				long quantityNeeded = productModel.getQuantity() - pEntity.getProductQuantity();
				pEntity.setProductQuantity(pEntity.getProductQuantity() - pEntity.getProductQuantity());
				productStockRepo.save(pEntity);
				rMatOrderService.rawToFinished(quantityNeeded, productModel.getProductName());
				result = convertProductOrder(productOrderRepo.save(convertProductOrder(productModel)));
			} else if (pEntity.getProductQuantity() == 0) {
				throw new ProductOrderException("We are out of Stock....Can't process Your Order");
			}
		} else {
			throw new ProductOrderException("Product Id not found");
		}

		return result;
	}
	@Override
	public List<ProductOrderModel> trackProductOrder(long id) throws ProductOrderException {

		List<ProductOrderModel> modelList = null;
		List<ProductOrderEntity> entityList = productOrderRepo.findByOrderId(id);
		long orderId = 0;
		for(ProductOrderEntity pOrderEntity : entityList ) {	
			orderId=pOrderEntity.getOrderId();
		}
		if (entityList!=null && orderId==id) {
			modelList = entityList.stream().map(p -> convertProductOrder(p))
					.collect(Collectors.toList());

		}
		else {
			throw new ProductOrderException("No order found with this order Id");
		}

		return modelList;

	}
	@Override
	public List<ProductStockEntity> trackProductStock() {
		List<ProductStockEntity> pStockList=productStockRepo.findAll();
		return pStockList;
		
	}
	@Override
	public String saveProduct(ProductStockEntity productStockEntity) throws ProductOrderException{
		long productId=productStockEntity.getProductId();
		ProductStockEntity productStockRepoEntity=productStockRepo.
				findById(productId).orElse(null);
		if(productStockRepoEntity!=null && productStockRepoEntity.getProductQuantity()!=0 ) {
		productStockEntity.setProductQuantity(productStockEntity.getProductQuantity()+
				productStockRepoEntity.getProductQuantity());
		productStockRepo.save(productStockEntity);
		}
		else {
			throw new ProductOrderException("Product Id is Wrong....can't add product to stock");
		}
		return "Product added to stock successfully";
		
	}
	
	
	@Override
	public String updateProductOrder(ProductOrderModel pOrderModel) throws ProductOrderException{
		String updateStatus = null;
		long orderId=pOrderModel.getOrderId();
		ProductOrderEntity entity = productOrderRepo.findById(orderId).orElse(null);
		if (entity != null) {
			if(pOrderModel.getDeliveryStatus()!=null) {
			entity.setDeliveryStatus(pOrderModel.getDeliveryStatus());
			  }
			if(pOrderModel.getExpectedDeliveryDate()!=null) {
			 entity.setExpectedDeliveryDate(pOrderModel.getExpectedDeliveryDate());
		       }
			productOrderRepo.save(entity);
			updateStatus = "Order Updated Successfully";
		} else
			updateStatus = "Order Id Does Not Exist";
		return updateStatus;
	}

}
