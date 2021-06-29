package com.gateway.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourierEntity {

	@Id
	@GeneratedValue
	@Basic(optional = false)
	@Column(nullable = false)
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false)
	private String service;

	@Basic(optional = false)
	@Column(nullable = false)
	private String url;

	@Basic(optional = false)
	@Column(nullable = false)
	private String serviceUsername;

	@Basic(optional = false)
	@Column(nullable = false)
	private String servicePassword;

	@Basic(optional = false)
	@Column(nullable = false)
	private String accountUsername;

	@Basic(optional = false)
	@Column(nullable = false)
	private String accountPassword;

	@Basic(optional = false)
	@Column(nullable = false)
	private String token;

}
