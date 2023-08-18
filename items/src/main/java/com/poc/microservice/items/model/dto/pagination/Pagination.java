package com.poc.microservice.items.model.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pagination {
    private int skip = 0;
    private int take = -1;
    private Optional<Sort> sort;
    private Optional<List<Filter>> filters;
    private Optional<List<Filter>> orFilters;
}
