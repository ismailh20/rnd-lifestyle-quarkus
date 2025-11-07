package id.co.lifestyle.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "guest_schedules")
public class GuestSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    @JsonIgnore
    public Guest guest;

    public Integer event_id;
    public LocalDate schedule_date;
    public LocalTime start_time;
    public LocalTime end_time;
    public String stage;
    public LocalDateTime created_at;
}
