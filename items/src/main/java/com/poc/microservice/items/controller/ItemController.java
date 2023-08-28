package com.poc.microservice.items.controller;

import com.poc.microservice.items.model.dto.pagination.Pagination;
import com.poc.microservice.items.model.dto.pagination.PaginationReturn;
import com.poc.microservice.items.model.entity.Item;
import com.poc.microservice.items.service.IitemService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item/")
@RequiredArgsConstructor
public class ItemController {
    private final IitemService service;

    private final Logger log = LoggerFactory.getLogger(ItemController.class);

    @PostMapping("")
    public PaginationReturn<Item> getAll(@RequestBody() Pagination pagination){
        return service.getAll(pagination);
    }

    @GetMapping("logInfo")
    public String logInfo(){
        log.info("Info log in logInfo method");
        return "logInfo";
    }

    @GetMapping("logWarn")
    public String logWarn(){
        log.warn("Warn log in logWarn method");
        return "logWarn";
    }

    @GetMapping("logError")
    public String logError(){
        log.error("Error log in logError method");
        return "logError";
    }

    @GetMapping("logTrace")
    public String logTrace(){
        log.trace("Trace log in logTrace method");
        return "logTrace";
    }

    @GetMapping("logDebug")
    public String logDebug(){
        String data = "esto es un dato en variable";
        log.debug("Debug log in logDebug method with {}", data);
        return "logDebug";
    }
}
