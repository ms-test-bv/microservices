package com.poc.microservice.items.model.entity;

import com.poc.microservice.items.model.entity.composite.ItemWarehouseId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item_warehouse")
public class ItemWarehouse implements Serializable {
    @EmbeddedId
    private ItemWarehouseId id; // Embedded id with item and warehouse (Two strings)

    @Column(name = "warehouse_name")
    private String warehouseName;

//    @MapsId("idItem") // This fk maps the id item in the item warehouse id
//    @ManyToOne
//    @JoinColumn(name = "id_item")
//    private Item item;
}
