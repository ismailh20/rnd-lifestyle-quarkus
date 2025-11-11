package id.co.lifestyle.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;
    public String email;
    public String phone;
    public String role;
    public String invitation_status;
    public String category;
    public String image;
    public Integer event_id;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<GuestSchedule> schedules;
}
