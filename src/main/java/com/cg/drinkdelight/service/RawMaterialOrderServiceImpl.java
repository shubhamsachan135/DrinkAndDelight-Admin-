package com.cg.drinkdelight.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkdelight.dao.RawMaterialOrderDao;
import com.cg.drinkdelight.dao.SupplierDao;
import com.cg.drinkdelight.entity.RawMaterialOrderEntity;
import com.cg.drinkdelight.entity.RawMaterialStockEntity;
import com.cg.drinkdelight.entity.SupplierEntity;

@Service
public class RawMaterialOrderServiceImpl implements RawMaterialOrderService {
	@Autowired
	RawMaterialOrderDao rMatDao;
	@Autowired
	SupplierDao suppDao;

	public void rawToFinished(long quantityNeeded, String neededProduct) {
		// long a=quantityNeeded*
		long rawMatQuantity;
		String rawMatName = null;
		switch (neededProduct) {
		case "MangoJuice":
			rawMatQuantity = quantityNeeded * 2;
			rawMatName = "Mango";
			placeRawMaterialOrder(rawMatQuantity, rawMatName);
			break;
		case "OrangeJuice":
			rawMatQuantity = quantityNeeded * 3;
			rawMatName = "Orange";
			placeRawMaterialOrder(rawMatQuantity, rawMatName);
			break;
		case "PineAppleJuice":
			rawMatQuantity = quantityNeeded * 1;
			rawMatName = "PineApple";
			placeRawMaterialOrder(rawMatQuantity, rawMatName);
			break;
		}

	}

	public void placeRawMaterialOrder(long rawMatQuantity, String rawMatName) {
		// RawMaterialOrderEntity rawMatEnt=new RawMaterialOrderEntity()
		List<SupplierEntity> suppEntityList = suppDao.findAll();
		for (SupplierEntity suppEntity : suppEntityList) {
			for (RawMaterialStockEntity rStockEntity : suppEntity.getRawMaterials()) {
				if (rStockEntity.getRawMaterialName().equals(rawMatName)
						&& rStockEntity.getRawMaterialQuantity() >= rawMatQuantity) {
					RawMaterialOrderEntity rawMatOrder = new RawMaterialOrderEntity(rStockEntity.getRawMaterialId(),
							rawMatName, suppEntity.getSupplierId(), rawMatQuantity, LocalDate.now());
					// rStockEntity.setRawMaterialQuantity(rStockEntity.getRawMaterialQuantity()-rawMatQuantity);
					rMatDao.save(rawMatOrder);
				}
			}
		}
//		Iterator<SupplierEntity> iterator = suppEntityList.iterator();
//		while (iterator.hasNext()) {
//			SupplierEntity suppEntity = iterator.next();
//			Iterator<RawMaterialStockEntity> rawMatEntity = suppEntity.getRawMaterials().iterator();
//            while(rawMatEntity.hasNext()){
//            	RawMaterialStockEntity rStockEntity = rawMatEntity.next();
//            	if(rStockEntity.getRawMaterialName()==rawMatName) {
//    		        if (rStockEntity.getRawMaterialQuantity()>=rawMatQuantity) {
//    		        	RawMaterialOrderEntity rawMatOrder=new RawMaterialOrderEntity(rStockEntity.getRawMaterialId(),
//    		        			rawMatName,suppEntity.getSupplierId(),rawMatQuantity,LocalDate.now());
//    		        	   rMatDao.save(rawMatOrder);
//  		        }
//             }
//           
	}

}
