package id.co.lifestyle.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_details")
public class TicketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "ticket_status")
    public String ticketStatus;

    @Column(name = "event_date")
    public LocalDate eventDate;
    
    @Column(name = "order_id")
    public Integer orderId;

    public String name;
    public Integer age;
    public String address;
    public String phone;
    public String email;
    public String gender;
}
