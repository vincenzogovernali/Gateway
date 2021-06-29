package com.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gateway.entity.CourierEntity;
import com.gateway.service.CourierService;
import com.gateway.specification.CourierSpecification;

@Controller("/api/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping
    public List<CourierEntity> getAll(CourierSpecification specification) {
        return this.courierService.getAll();
    }

}
