package com.cg.drinkdelight.service;

import java.time.LocalDate;
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
	RawMaterialOrderDao rawMatDao;
	@Autowired
	SupplierDao suppDao;

	public void rawToFinished(long quantityNeeded, String neededProduct) {
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

		List<SupplierEntity> suppEntityList = suppDao.findAll();
		aa: for (SupplierEntity suppEntity : suppEntityList) {
			for (RawMaterialStockEntity rawStockEntity : suppEntity.getRawMaterials()) {
				if (rawStockEntity.getRawMaterialName().equals(rawMatName)
						&& rawStockEntity.getRawMaterialQuantity() >= rawMatQuantity) {
					RawMaterialOrderEntity rawMatOrder = new RawMaterialOrderEntity(rawStockEntity.getRawMaterialId(),
							rawMatName, suppEntity.getSupplierId(), rawMatQuantity, LocalDate.now());
					rawMatDao.save(rawMatOrder);
					break aa;
				}
			}
		}

	}

}
