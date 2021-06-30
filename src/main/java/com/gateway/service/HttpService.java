package com.gateway.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import com.gateway.entity.HeaderEntity;

@Service
public class HttpService {

    public Object get(String url, List<HeaderEntity> headers, Class<?> classType) {
        try {
            RequestHeadersUriSpec<?> spec = WebClient.create(url).get();
            if (headers != null && !headers.isEmpty()) {
                addHeaders(spec, headers);
            }

            return spec.retrieve().bodyToMono(classType).block(Duration.ofMinutes(1));
        } catch (Exception e) {
            return null;
        }

    }

    public Object post(String url, List<HeaderEntity> headers, Class<?> classType, Object body) {
        try {
            RequestBodyUriSpec spec = WebClient.create(url).post();
            if (headers != null && !headers.isEmpty()) {
                addHeaders(spec, headers);
            }
            if (body != null) {
                spec.bodyValue(body);
            }
            return spec.retrieve().bodyToMono(classType).block(Duration.ofMinutes(1));
        } catch (Exception e) {
            return null;
        }
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
