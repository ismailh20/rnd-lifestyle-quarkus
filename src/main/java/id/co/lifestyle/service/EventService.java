package id.co.lifestyle.service;

import id.co.lifestyle.model.Event;
import id.co.lifestyle.repository.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class EventService {

    @Inject
    EventRepository eventRepository;

    public Optional<Event> getEventByIdAndMerchant(Integer eventId, Integer merchantId) {
        return eventRepository.findByEventIdAndMerchantId(eventId, merchantId);
    }
}

