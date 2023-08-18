package com.poc.microservice.items.model.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public  class PaginationReturn <T> {
    public long totalItems;
    public List<T> items;
    public int totalPages;
}
