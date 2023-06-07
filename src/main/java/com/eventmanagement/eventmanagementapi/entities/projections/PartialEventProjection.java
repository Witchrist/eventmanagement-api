package com.eventmanagement.eventmanagementapi.entities.projections;

import com.eventmanagement.eventmanagementapi.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.ZonedDateTime;

@Projection(name = "partial",types = {Event.class})
public interface PartialEventProjection {

    String getName();
    ZonedDateTime getStartTime();
    ZonedDateTime getEndTime();
}
