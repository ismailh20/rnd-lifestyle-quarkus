package id.co.lifestyle.controller;

import id.co.lifestyle.model.Event;
import id.co.lifestyle.service.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

    @Inject
    EventService eventService;

    @GET
    public Response getEvent(
        @QueryParam("event_id") Integer eventId,
        @QueryParam("merchant_id") Integer merchantId
    ) {
        if (eventId == null || merchantId == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Parameter event_id dan merchant_id wajib diisi")
                .build();
        }

        Optional<Event> event = eventService.getEventByIdAndMerchant(eventId, merchantId);
        if (event.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Event tidak ditemukan")
                .build();
        }

        return Response.ok(event.get()).build();
    }
}
