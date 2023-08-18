package com.poc.microservice.items.model.entity;

import com.poc.microservice.items.core.base.BaseClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Item extends BaseClass implements Serializable {
    @Column()
    private String name;

    @Column(name = "base_price")
    private Double basePrice;
//
//    @ManyToOne(targetEntity = ItemType.class)
//    @JoinTable(name = "type_id") // The name of the column
//    private ItemType type;
//
//    @OneToMany(mappedBy = "item") // The variable in the other side
//    private Set<ItemWarehouse> warehouses;
}
