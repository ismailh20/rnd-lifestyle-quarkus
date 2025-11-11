package id.co.lifestyle.repository;

import id.co.lifestyle.model.Orders;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Orders> {}