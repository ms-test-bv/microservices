package com.poc.microservice.items.repository;

import com.poc.microservice.items.model.entity.ItemWarehouse;
import com.poc.microservice.items.model.entity.composite.ItemWarehouseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemWarehouseRepository extends JpaRepository<ItemWarehouse, ItemWarehouseId> {
}
