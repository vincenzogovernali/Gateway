package com.gateway.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.gateway.dto.CourierDTO;
import com.gateway.entity.CourierEntity;

public class CourierMapper {

    public static CourierDTO toDTO(CourierEntity entity) {
        CourierDTO dto = new CourierDTO();
        dto.setId(entity.getId());
        dto.setService(entity.getService());
        dto.setAccountUsername(entity.getAccountUsername());
        dto.setAccountPassword(entity.getAccountPassword());
        dto.setServiceUsername(entity.getServiceUsername());
        dto.setServicePassword(entity.getServicePassword());
        dto.setToken(entity.getToken());
        return dto;
    }

    public static CourierEntity toEntity(CourierDTO dto) {
        CourierEntity entity = new CourierEntity();
        entity.setId(dto.getId());
        entity.setService(dto.getService());
        entity.setAccountUsername(dto.getAccountUsername());
        entity.setAccountPassword(dto.getAccountPassword());
        entity.setServiceUsername(dto.getServiceUsername());
        entity.setServicePassword(dto.getServicePassword());
        entity.setToken(dto.getToken());
        return entity;
    }

    public static List<CourierDTO> toDTO(List<CourierEntity> entity) {
        return entity.stream().map(CourierMapper::toDTO).collect(Collectors.toList());
    }

    public static List<CourierEntity> toEntity(List<CourierDTO> dto) {
        return dto.stream().map(CourierMapper::toEntity).collect(Collectors.toList());

    }

}
