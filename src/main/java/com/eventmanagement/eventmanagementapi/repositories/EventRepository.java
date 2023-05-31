package com.eventmanagement.eventmanagementapi.repositories;

import com.eventmanagement.eventmanagementapi.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepository  extends JpaRepository<Event, Long> {

    Optional<Event> findById(@Param("resourceId") Long id);
}
