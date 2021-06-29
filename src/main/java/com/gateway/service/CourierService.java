package com.gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.criteria.CourierCriteria;
import com.gateway.entity.CourierEntity;
import com.gateway.repository.CourierRepository;
import com.gateway.specification.CourierSpecification;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;

	public List<CourierEntity> getAll(CourierCriteria criteria) {
		return this.courierRepository.findAll(CourierSpecification.courierEntitySpecification(criteria));
	}

	public void save(CourierEntity entity) {
		this.courierRepository.save(entity);
	}

}
