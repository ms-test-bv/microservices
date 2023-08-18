package com.poc.microservice.items.service;


import com.poc.microservice.items.model.dto.pagination.Pagination;
import com.poc.microservice.items.model.dto.pagination.PaginationReturn;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface IService <T> {
    public PaginationReturn<T> getAll(Pagination pagination);
}
