package com.gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.criteria.CourierCriteria;
import com.gateway.dto.CourierDTO;
import com.gateway.entity.CourierEntity;
import com.gateway.mapper.CourierMapper;
import com.gateway.repository.CourierRepository;
import com.gateway.specification.CourierSpecification;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;

	public List<CourierEntity> getAll(CourierCriteria criteria) {
		return this.courierRepository.findAll(CourierSpecification.courierEntitySpecification(criteria));
	}

    public void saveOrUpdate(CourierDTO dto) {
        this.courierRepository.save(CourierMapper.toEntity(dto));
	}

    public void saveOrUpdateAll(List<CourierDTO> dtos) {
        this.courierRepository.saveAll(CourierMapper.toEntity(dtos));
    }

    public void delete(CourierDTO dto) {
        this.courierRepository.delete(CourierMapper.toEntity(dto));
    }

    public void deleteAll(List<CourierDTO> dtos) {
        this.courierRepository.deleteAll(CourierMapper.toEntity(dtos));
    }

}
