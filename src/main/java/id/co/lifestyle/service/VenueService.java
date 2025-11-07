package id.co.lifestyle.service;

import id.co.lifestyle.dto.Facilities;
import id.co.lifestyle.dto.VenueData;
import id.co.lifestyle.model.Event;
import id.co.lifestyle.model.Facility;
import id.co.lifestyle.repository.EventRepository;
import id.co.lifestyle.repository.FacilityRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VenueService {

    @Inject
    EventRepository eventRepository;

    @Inject
    FacilityRepository facilityRepository;

    public VenueData getVenue(Integer eventId, Integer merchantId) {

        Event event = eventRepository.findByEventIdAndMerchantId(eventId, merchantId).orElse(null);

        if (event == null) {
            return null;
        }

        List<Facility> facilities = facilityRepository.findByEvent(eventId);

        VenueData dto = new VenueData();
        dto.location = event.getLocation();
        dto.capacity = event.getCapacity();
        dto.image_venue = event.getImageVenue();

        Facilities f = new Facilities();
        facilities.forEach(fac -> {
            if ("parking".equalsIgnoreCase(fac.getCategory())) {
                f.parking = fac.getDescription();
            }
            if ("food".equalsIgnoreCase(fac.getCategory())) {
                f.food_court = fac.getDescription();
            }
        });

        dto.facilities = f;
        return dto;
    }
}
