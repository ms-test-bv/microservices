package com.poc.microservice.items.repository;

import com.poc.microservice.items.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>, JpaSpecificationExecutor<Item> {
}
