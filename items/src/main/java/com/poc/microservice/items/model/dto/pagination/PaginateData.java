package com.poc.microservice.items.model.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PaginateData <T> {
    public Pageable pageable;
    public Optional<Specification<T>> specification;
}
