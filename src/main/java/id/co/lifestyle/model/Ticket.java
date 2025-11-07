package id.co.lifestyle.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticket_type")
    private String ticketType;

    private Double price;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "valid_from_date")
    private LocalDate validFromDate;

    @Column(name = "valid_to_date")
    private LocalDate validToDate;

    @Column(name = "access_special_show")
    private Boolean accessSpecialShow;

    @Column(name = "event_id")
    private Integer eventId;

    // ==== GETTERS & SETTERS ====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDate getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(LocalDate validFromDate) {
        this.validFromDate = validFromDate;
    }

    public LocalDate getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(LocalDate validToDate) {
        this.validToDate = validToDate;
    }

    public Boolean getAccessSpecialShow() {
        return accessSpecialShow;
    }

    public void setAccessSpecialShow(Boolean accessSpecialShow) {
        this.accessSpecialShow = accessSpecialShow;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
