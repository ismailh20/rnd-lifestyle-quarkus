package id.co.lifestyle.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

import id.co.lifestyle.model.Guest;

@ApplicationScoped
public class GuestRepository implements PanacheRepository<Guest> {

    public List<Guest> findByEventId(Long eventId) {
        return find("event_id", eventId).list();
    }
}

