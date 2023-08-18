package com.poc.microservice.items.model.dto;

import com.poc.microservice.items.model.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class ItemTypeDto {
    private String id;
    private String name;
    private Optional<Set<Item>> items;
}
