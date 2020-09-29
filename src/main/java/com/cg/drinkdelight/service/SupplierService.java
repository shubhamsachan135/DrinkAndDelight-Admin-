package com.cg.drinkdelight.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.drinkdelight.dao.SupplierDao;
import com.cg.drinkdelight.entity.RawMaterialStockEntity;
import com.cg.drinkdelight.entity.SupplierEntity;

@Service
public class SupplierService {
	@Autowired
	SupplierDao suppDao;

	public void saveSupplier() {
		ArrayList<RawMaterialStockEntity> rList1 = new ArrayList<RawMaterialStockEntity>();
		rList1.add(new RawMaterialStockEntity(101, 2000, "Mango"));
		rList1.add(new RawMaterialStockEntity(102, 1800, "Apple"));
		rList1.add(new RawMaterialStockEntity(103, 1600, "Kiwi"));
		SupplierEntity suppEntity1 = new SupplierEntity(501, "Shubham", rList1);
		suppDao.save(suppEntity1);

		ArrayList<RawMaterialStockEntity> rList2 = new ArrayList<RawMaterialStockEntity>();
		rList2.add(new RawMaterialStockEntity(201, 1400, "Mango"));
		rList2.add(new RawMaterialStockEntity(202, 1200, "Apple"));
		rList2.add(new RawMaterialStockEntity(203, 1000, "Orange"));
		SupplierEntity suppEntity2 = new SupplierEntity(601, "Utkarsh", rList2);
		suppDao.save(suppEntity2);

		ArrayList<RawMaterialStockEntity> rList3 = new ArrayList<RawMaterialStockEntity>();
		rList3.add(new RawMaterialStockEntity(301, 800, "Mango"));
		rList3.add(new RawMaterialStockEntity(302, 600, "PineApple"));
		rList3.add(new RawMaterialStockEntity(303, 400, "Cherry"));
		SupplierEntity suppEntity3 = new SupplierEntity(701, "Sudhanshu", rList3);
		suppDao.save(suppEntity3);
	}
}
