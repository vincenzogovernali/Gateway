package com.gateway.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import com.gateway.entity.HeaderEntity;

import reactor.core.publisher.Flux;

@Service
public class HttpService {

    public Flux<?> get(String url, List<HeaderEntity> headers, Class<?> classType) {
        RequestHeadersUriSpec<?> spec = WebClient.create(url).get();    
        if(headers != null && !headers.isEmpty()) {
            addHeaders(spec, headers);
        }
        
        return spec.retrieve().bodyToFlux(classType);
    }

    public Flux<?> post(String url, List<HeaderEntity> headers, Class<?> classType, Object body) {
        RequestBodyUriSpec spec = WebClient.create(url).post();
        if (headers != null && !headers.isEmpty()) {
            addHeaders(spec, headers);
        }
        if (body != null) {
            spec.bodyValue(body);
        }
        return spec.retrieve().bodyToFlux(classType);
    }

    /**
     * Ciclo gli Headers e li aggiungo alla chiamata
     * 
     * @param spec
     * @param headers
     */
    protected void addHeaders(RequestHeadersUriSpec<?> spec, List<HeaderEntity> headers) {
        headers.forEach(header -> spec.header(header.getKey(), header.getValue()));
    }

}
