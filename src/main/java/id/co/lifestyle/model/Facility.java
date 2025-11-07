package id.co.lifestyle.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "facilities")
public class Facility extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "text")
    private String description;

    private String category;

    // ==== GETTERS & SETTERS ====

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getEventId() { return eventId; }

    public void setEventId(Integer eventId) { this.eventId = eventId; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
