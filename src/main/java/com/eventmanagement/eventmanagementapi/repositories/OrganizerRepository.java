package com.eventmanagement.eventmanagementapi.repositories;

import com.eventmanagement.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizerRepository  extends CrudRepository<Organizer, Long> {
}
