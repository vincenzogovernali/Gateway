package com.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "courier")
public class CourierEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String service;

	@Column(nullable = false)
	private String url;

	@Column(nullable = true)
	private String serviceUsername;

	@Column(nullable = true)
	private String servicePassword;

	@Column(nullable = true)
	private String accountUsername;

	@Column(nullable = true)
	private String accountPassword;

	@Column(nullable = true)
	private String token;

}
