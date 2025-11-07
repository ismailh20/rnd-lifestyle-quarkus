package id.co.lifestyle.repository;

import id.co.lifestyle.model.Facility;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FacilityRepository implements PanacheRepository<Facility> {
    public List<Facility> findByEvent(Integer eventId) {
        return list("eventId", eventId); // ✅ pakai camelCase sesuai field di entity
    }
}

