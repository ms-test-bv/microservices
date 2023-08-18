package com.poc.microservice.items.service;

import com.poc.microservice.items.model.entity.ItemType;

import java.util.Set;

public interface IitemTypeService {
    public ItemType createItemType();
    public ItemType updateItemType();
    public Set<ItemType> getItemTypes();
    public ItemType getItemType(String id);
    public void deleteItemTypes(String[] id);
}
