package id.co.lifestyle.repository;

import id.co.lifestyle.model.TicketDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketDetailRepository implements PanacheRepository<TicketDetail> {}
