package com.eventmanagement.eventmanagementapi.entities;

import java.time.Instant;

import jakarta.persistence.*;


import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@CreationTimestamp
	@Column(updatable = false)
	protected Instant created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

}
