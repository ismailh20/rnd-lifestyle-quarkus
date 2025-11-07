package id.co.lifestyle.controller;

import id.co.lifestyle.dto.TicketTypeDTO;
import id.co.lifestyle.service.TicketService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tickets/event")
@Produces(MediaType.APPLICATION_JSON)
public class TicketController {

    @Inject
    TicketService ticketService;

    @GET
    public List<TicketTypeDTO> getTickets(@QueryParam("event_id") Integer eventId) {
        return ticketService.getTickets(eventId);
    }
}
