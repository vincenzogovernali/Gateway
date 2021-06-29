package com.gateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gateway.entity.CourierEntity;

@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long>, JpaSpecificationExecutor<CourierEntity> {

	List<CourierEntity> findAllByIdLike(Long id);

}
