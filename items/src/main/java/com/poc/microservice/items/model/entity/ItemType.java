package com.poc.microservice.items.model.entity;

import com.poc.microservice.items.core.base.BaseClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "item_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ItemType extends BaseClass implements Serializable  {
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "type") // The variable in the other side
//    private Set<Item> items;
}
