package com.poc.microservice.items.controller;

import com.poc.microservice.items.model.dto.pagination.Pagination;
import com.poc.microservice.items.model.dto.pagination.PaginationReturn;
import com.poc.microservice.items.model.entity.Item;
import com.poc.microservice.items.service.IitemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item/")
@AllArgsConstructor
public class ItemController {
    private final IitemService service;

    @PostMapping("")
    public PaginationReturn<Item> getAll(@RequestBody() Pagination pagination){
        return service.getAll(pagination);
    }
}
