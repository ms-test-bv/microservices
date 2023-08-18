package com.poc.microservice.items.service;

import com.poc.microservice.items.model.entity.Item;

import java.util.Set;

public interface IitemService extends IService<Item> {
    public Item createItem();
    public Item updateItem();
    public Item getItem(String id);
    public void deleteItems(String[] id);
}
