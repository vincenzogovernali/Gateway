package com.gateway.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gateway.entity.CourierEntity;
import com.gateway.entity.CourierEntity_;

import lombok.Data;

@Data
public class CourierSpecification {

	private Long id;
	private String service;
	private String url;
	private String serviceUsername;
	private String servicePassword;
	private String accountUsername;
	private String accountPassword;
	private String token;

	public static Specification<CourierEntity> customerHasBirthday() {
		return new Specification<CourierEntity>() {

			private static final long serialVersionUID = 5003585443426119934L;

			public Predicate toPredicate(Root<CourierEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(CourierEntity_.url), null);
			}

		};
	}

}
