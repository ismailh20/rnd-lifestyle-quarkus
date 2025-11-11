package id.co.lifestyle.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "event_id")
    public Integer eventId;

    @Column(name = "ticket_id")
    public Integer ticketId;

    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "order_date")
    public LocalDate order_date;

    public String status;
    public Integer quantity;
    public Integer price;
}
