package id.co.lifestyle.controller;

import id.co.lifestyle.dto.VenueData;
import id.co.lifestyle.service.VenueService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/facilities/venue")
@Produces(MediaType.APPLICATION_JSON)
public class VenueController {

    @Inject
    VenueService venueService;

    @GET
    public VenueData getVenue(
            @QueryParam("event_id") Integer eventId,
            @QueryParam("merchant_id") Integer merchantId
    ) {
        return venueService.getVenue(eventId, merchantId);
    }
}
