package com.javacodestuffs.spring.boot.rest.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.StringUtils;

import com.javacodestuffs.spring.boot.rest.utils.SpringUtils;

/**
 * Entity listener for all Entities/Models
 *
 */
public class SpringEntityListener {

	@PrePersist
	private void beforeInsert(AbstractJpaEntity abstractEntity) {
		if (abstractEntity.getCreatedAt() == null) {
			abstractEntity.setCreatedAt(new Date());
		}
		if (abstractEntity.getUpdatedAt() == null) {
			abstractEntity.setUpdatedAt(new Date());
		}

		if (StringUtils.isBlank(abstractEntity.getUuid())) {
			abstractEntity.setUuid(SpringUtils.generateUniqueId());
		}	

	}

	@PreUpdate
	private void beforeUpdate(AbstractJpaEntity abstractEntity) {
		if (abstractEntity.getCreatedAt() == null) {
			abstractEntity.setCreatedAt(new Date());
		}

		abstractEntity.setUpdatedAt(new Date());
	}
}