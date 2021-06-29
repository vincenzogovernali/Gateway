package com.gateway.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import com.gateway.entity.HeaderEntity;

import reactor.core.publisher.Mono;

@Service
public class HttpService {

    public Mono<?> get(String url, List<HeaderEntity> headers, Class<?> classType) {
        RequestHeadersUriSpec<?> spec = WebClient.create(url).get();    
        if(headers != null && !headers.isEmpty()) {
            addHeaders(spec, headers);
        }
        
        return spec.retrieve().bodyToMono(classType);
    }

    public Mono<?> post(String url, List<HeaderEntity> headers, Class<?> classType, Object body) {
        RequestBodyUriSpec spec = WebClient.create(url).post();
        if (headers != null && !headers.isEmpty()) {
            addHeaders(spec, headers);
        }
        if (body != null) {
            spec.bodyValue(body);
        }
        return spec.retrieve().bodyToMono(classType);
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
