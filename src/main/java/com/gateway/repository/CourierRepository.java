package com.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gateway.entity.CourierEntity;

@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long>, JpaSpecificationExecutor<CourierEntity> {

}
