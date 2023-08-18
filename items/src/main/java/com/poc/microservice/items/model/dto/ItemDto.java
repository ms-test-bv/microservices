package com.poc.microservice.items.model.dto;

import com.poc.microservice.items.model.entity.ItemType;
import com.poc.microservice.items.model.entity.ItemWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Optional;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ItemDto {
    private String id;
    private String name;
    private Double basePrice;
    private ItemType type;
    private Optional<Set<ItemWarehouse>> warehouses;
}
