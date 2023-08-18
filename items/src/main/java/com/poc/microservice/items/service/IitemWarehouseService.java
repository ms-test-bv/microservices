package com.poc.microservice.items.service;

import com.poc.microservice.items.model.entity.ItemWarehouse;

import java.util.Set;

public interface IitemWarehouseService {
    public ItemWarehouse createItemWarehouse();
    public ItemWarehouse updateItemWarehouse();
    public Set<ItemWarehouse> getItemWarehouse();
    public ItemWarehouse getItemWarehouse(String id);
    public void deleteItemWarehouses(String[] id);
}
