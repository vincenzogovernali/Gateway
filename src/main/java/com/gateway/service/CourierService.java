package com.gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.gateway.entity.CourierEntity;
import com.gateway.repository.CourierRepository;
import com.gateway.specification.CourierSpecification;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;

	public List<CourierEntity> getAll(CourierSpecification specification) {
		return this.courierRepository.findAll(createExampleList(specification));
	}

	private Example<CourierEntity> createExampleList(CourierSpecification specification) {
		CourierEntity entity = new CourierEntity(specification.getId(), specification.getService(),
				specification.getUrl(), specification.getServiceUsername(), specification.getServicePassword(),
				specification.getAccountUsername(), specification.getAccountPassword(), specification.getToken());
		Example<CourierEntity> example = Example.of(CourierEntity.fr);

		return null;
	}

}
