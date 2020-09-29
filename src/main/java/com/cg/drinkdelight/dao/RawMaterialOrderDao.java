package com.cg.drinkdelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.drinkdelight.entity.RawMaterialOrderEntity;


@Repository
public interface RawMaterialOrderDao extends JpaRepository<RawMaterialOrderEntity,Long> {

}
