package id.co.lifestyle.repository;

import id.co.lifestyle.model.Ticket;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TicketRepository implements PanacheRepository<Ticket> {
    public List<Ticket> findByEvent(Integer eventId) {
        return list("eventId", eventId); 
    }
}
