package id.co.lifestyle.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import id.co.lifestyle.dto.GuestStarDTO;
import id.co.lifestyle.service.GuestService;

@Path("/guests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {

    @Inject
    GuestService guestService;

    @GET
    @Path("/stars")
    public List<GuestStarDTO> getGuestStars(@QueryParam("event_id") Long eventId) {
        if (eventId == null) {
            throw new WebApplicationException("event_id is required", 400);
        }
        return guestService.getGuestStars(eventId);
    }
}
