package com.gateway.specification;

import lombok.Data;

@Data
public class CourierSpecification {

    private String service;
    private String url;
    private String serviceUsername;
    private String servicePassword;
    private String accountUsername;
    private String accountPassword;
    private String token;

}
