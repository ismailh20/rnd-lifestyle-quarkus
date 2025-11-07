package id.co.lifestyle.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import id.co.lifestyle.dto.GuestStarDTO;
import id.co.lifestyle.model.Guest;
import id.co.lifestyle.model.GuestSchedule;
import id.co.lifestyle.repository.GuestRepository;

@ApplicationScoped
public class GuestService {

    @Inject
    GuestRepository guestRepository;

    public List<GuestStarDTO> getGuestStars(Long eventId) {
        List<Guest> guests = guestRepository.findByEventId(eventId);

        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");

        return guests.stream().map(guest -> {
            GuestStarDTO dto = new GuestStarDTO();
            dto.name = guest.name;
            dto.genre = guest.category;
            dto.image = guest.image;

            if (guest.schedules != null && !guest.schedules.isEmpty()) {
                // Ambil jadwal pertama (kalau ada)
                GuestSchedule sch = guest.schedules.get(0);
                dto.day = "Hari " + (sch.schedule_date != null ? getDayNumber(sch.schedule_date) : "-");
                dto.stage = sch.stage;
                dto.time = (sch.start_time != null && sch.end_time != null)
                        ? sch.start_time.format(timeFmt) + " - " + sch.end_time.format(timeFmt)
                        : "-";
            } else {
                dto.day = "-";
                dto.stage = "-";
                dto.time = "-";
            }

            return dto;
        }).collect(Collectors.toList());
    }

    // contoh simple mapping hari dari tanggal (Hari 1, Hari 2, dst)
    private int getDayNumber(java.time.LocalDate date) {
        return date.getDayOfMonth(); // bisa custom kalau ada logika hari tertentu
    }
}
