package com.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.criteria.CourierCriteria;
import com.gateway.entity.CourierEntity;
import com.gateway.service.CourierService;

@RestController
@RequestMapping(value = "/api/courier")
public class CourierController {

	@Autowired
	private CourierService courierService;

	@GetMapping
	public List<CourierEntity> getAll(CourierCriteria criteria) {
		return this.courierService.getAll(criteria);
	}

	@PostMapping
	public void save(@RequestBody CourierEntity entity) {
		this.courierService.save(entity);
	}

}
