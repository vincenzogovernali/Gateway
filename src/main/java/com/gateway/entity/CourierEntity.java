package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierEntity {

    private Long id;
	private String service;
	private String url;
	private String serviceUsername;
	private String servicePassword;
	private String accountUsername;
	private String accountPassword;
	private String token;

}
