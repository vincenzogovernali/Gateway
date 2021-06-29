package com.gateway.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class HeaderEntity {

    @NonNull
    private String key;

    @NonNull
    private String value;

}
