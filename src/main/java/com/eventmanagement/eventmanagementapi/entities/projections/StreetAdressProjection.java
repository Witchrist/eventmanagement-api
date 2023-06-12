package com.eventmanagement.eventmanagementapi.entities.projections;

import com.eventmanagement.eventmanagementapi.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "virtualProjection", types = {Venue.class})
public interface StreetAdressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteVenueAdress();
}
