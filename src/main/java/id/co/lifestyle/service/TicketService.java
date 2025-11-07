package id.co.lifestyle.service;

import id.co.lifestyle.dto.TicketTypeDTO;
import id.co.lifestyle.model.Ticket;
import id.co.lifestyle.repository.TicketRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ApplicationScoped
public class TicketService {

    @Inject
    TicketRepository ticketRepository;

    public List<TicketTypeDTO> getTickets(Integer eventId) {
        List<Ticket> tickets = ticketRepository.findByEvent(eventId);

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        return tickets.stream().map(t -> {
            TicketTypeDTO dto = new TicketTypeDTO();
            dto.id = t.getId();
            dto.ticket_type = t.getTicketType();
            dto.price = t.getPrice();
            dto.quantity_available = t.getQuantityAvailable();
            dto.valid_from_date = t.getValidFromDate() != null ? t.getValidFromDate().toString() : null;
            dto.valid_to_date = t.getValidToDate() != null ? t.getValidToDate().toString() : null;
            dto.access_special_show = t.getAccessSpecialShow();
            dto.displayText = t.getTicketType() + " – " + rupiah.format(t.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }
}
