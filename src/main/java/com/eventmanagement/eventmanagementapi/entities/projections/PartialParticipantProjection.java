package com.eventmanagement.eventmanagementapi.entities.projections;

import com.eventmanagement.eventmanagementapi.entities.Participant;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "partial",types = {Participant.class})
public interface PartialParticipantProjection {

    String getName();
    Boolean getCheckedIn();
}
