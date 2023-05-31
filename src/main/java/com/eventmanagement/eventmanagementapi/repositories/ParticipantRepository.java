package com.eventmanagement.eventmanagementapi.repositories;

import com.eventmanagement.eventmanagementapi.entities.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParticipantRepository  extends JpaRepository<Participant, Long> {

    Page<Participant> findByEmail(@Param("email") String email, Pageable pageable);
}
