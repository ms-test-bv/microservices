package com.poc.microservice.items.model.entity.composite;

import com.poc.microservice.items.model.entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ItemWarehouseId{
    @Column(name = "id_item")
    private String idItem;

    @Column(name = "id_warehouse")
    private String idWarehouse;
}
