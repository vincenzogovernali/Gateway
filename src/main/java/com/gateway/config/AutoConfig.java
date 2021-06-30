package com.gateway.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.gateway.criteria.CourierCriteria;
import com.gateway.entity.CourierEntity;
import com.gateway.service.CourierService;
import com.gateway.service.HttpService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AutoConfig {

    private List<Long> portList = Arrays.asList(8080L, 8081L, 8082L);

    private final String baseUrl = "http://localhost:";

    private final String finalUrl = "/getInfo";

    @Bean
    @DependsOn({"createConnection"})
    public List<Long> startWarmUp(HttpService service, CourierService courierService) {
        this.portList.forEach(port -> {
            CourierEntity fluxCourierEntity = (CourierEntity) service.get(this.baseUrl.concat(port.toString()).concat(this.finalUrl), null, CourierEntity.class);
            if (fluxCourierEntity != null) {
                CourierCriteria criteria = new CourierCriteria();
                criteria.setService(fluxCourierEntity.getService());
                List<CourierEntity> list = courierService.getAll(criteria);
                if (list != null && !list.isEmpty()) {
                    // AGGIUNTA LATO DB
                }
            } else {
                log.debug("Nessun microservizio trovato alla porta: ".concat(port.toString()));
            }

        });
        return this.portList;
    }

}
