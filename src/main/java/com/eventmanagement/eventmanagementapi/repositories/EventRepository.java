package com.eventmanagement.eventmanagementapi.repositories;

import com.eventmanagement.eventmanagementapi.entities.Event;
import com.eventmanagement.eventmanagementapi.entities.projections.PartialEventProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository  extends JpaRepository<Event, Long> {

    Optional<Event> findById(@Param("resourceId") Long id);
}
