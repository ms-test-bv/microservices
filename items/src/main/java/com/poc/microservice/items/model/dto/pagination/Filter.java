package com.poc.microservice.items.model.dto.pagination;

import com.poc.microservice.items.core.pagination.operations.Operations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Filter {
    private String field;
    private Operations operation;
    private List<String> value;
}
