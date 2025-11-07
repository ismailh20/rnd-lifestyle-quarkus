package id.co.lifestyle.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

import id.co.lifestyle.model.Event;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {

    public Optional<Event> findByEventIdAndMerchantId(Integer eventId, Integer merchantId) {
        return find("id = ?1 AND merchantId = ?2", eventId, merchantId).firstResultOptional();
    }
}
