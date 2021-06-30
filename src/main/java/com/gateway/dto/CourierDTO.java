package com.gateway.dto;

import lombok.Data;

@Data
public class CourierDTO {

	private Long id;

	private String service;

	private String url;

	private String serviceUsername;

	private String servicePassword;

	private String accountUsername;

	private String accountPassword;

	private String token;
}
