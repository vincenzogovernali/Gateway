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

            @Override
            public Predicate toPredicate(Root<CourierEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (criteria.getId() != null) {
                    predicate = cb.equal(root.get(CourierEntity_.id), criteria.getId());
                }
                if (criteria.getService() != null) {
                    predicate = cb.like(root.get(CourierEntity_.service), buildLike(criteria.getService()));
                }
                if (criteria.getUrl() != null) {
                    predicate = cb.like(root.get(CourierEntity_.url), buildLike(criteria.getUrl()));
                }
                if (criteria.getServiceUsername() != null) {
                    predicate = cb.like(root.get(CourierEntity_.serviceUsername), buildLike(criteria.getServiceUsername()));
                }
                if (criteria.getServicePassword() != null) {
                    predicate = cb.like(root.get(CourierEntity_.servicePassword), buildLike(criteria.getServicePassword()));
                }
                if (criteria.getAccountUsername() != null) {
                    predicate = cb.like(root.get(CourierEntity_.accountUsername), buildLike(criteria.getAccountUsername()));
                }
                if (criteria.getAccountPassword() != null) {
                    predicate = cb.like(root.get(CourierEntity_.accountPassword), buildLike(criteria.getAccountPassword()));
                }
                if (criteria.getToken() != null) {
                    predicate = cb.like(root.get(CourierEntity_.token), buildLike(criteria.getToken()));
                }
                return predicate;
			}

		};
	}

    static String buildLike(String value) {
        return "%".concat(value.toLowerCase()).concat("%");
    }

}
