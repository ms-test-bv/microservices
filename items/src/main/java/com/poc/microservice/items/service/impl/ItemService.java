package com.poc.microservice.items.service.impl;

import com.poc.microservice.items.core.pagination.Paginate;
import com.poc.microservice.items.model.dto.pagination.PaginateData;
import com.poc.microservice.items.model.dto.pagination.Pagination;
import com.poc.microservice.items.model.dto.pagination.PaginationReturn;
import com.poc.microservice.items.model.entity.Item;
import com.poc.microservice.items.repository.ItemRepository;
import com.poc.microservice.items.service.IitemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ItemService implements IitemService {

    private final ItemRepository itemRepository;

    @Override
    public Item createItem() {
        return null;
    }

    @Override
    public Item updateItem() {
        return null;
    }


    @Override
    public Item getItem(String id) {
        return null;
    }

    @Override
    public void deleteItems(String[] id) {

    }

    @Override
    public PaginationReturn<Item> getAll(Pagination pagination) {
        PaginateData<Item> paginateData = Paginate.paginate(pagination);
        PaginationReturn<Item> paginationReturn = new PaginationReturn<>();
        Page page = null;
        if (paginateData.getSpecification() != null) {
            page = itemRepository.findAll(paginateData.getSpecification().get(), paginateData.pageable);
                    }
        else {
            page = itemRepository.findAll(paginateData.pageable);
        }

        paginationReturn.setItems(page.getContent()).setTotalItems(page.getTotalElements()).setTotalPages(page.getTotalPages());

        return paginationReturn;
    }
}
