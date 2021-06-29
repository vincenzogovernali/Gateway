package com.gateway.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gateway.criteria.CourierCriteria;
import com.gateway.entity.CourierEntity;
import com.gateway.entity.CourierEntity_;

public class CourierSpecification {

	public static Specification<CourierEntity> courierEntitySpecification(CourierCriteria criteria) {
		return new Specification<CourierEntity>() {

			private static final long serialVersionUID = 5003585443426119934L;

			public Predicate toPredicate(Root<CourierEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(CourierEntity_.url), null);
			}

		};
	}

}
