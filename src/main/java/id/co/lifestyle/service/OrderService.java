package id.co.lifestyle.service;

// import id.co.lifestyle.model.*;
import id.co.lifestyle.model.Orders;
import id.co.lifestyle.model.User;
import id.co.lifestyle.model.Ticket;
import id.co.lifestyle.model.TicketDetail;

import id.co.lifestyle.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;

// import org.apache.kafka.common.protocol.types.Field.Str;

@ApplicationScoped
public class OrderService {

    @Inject
    UserRepository userRepository;

    @Inject
    TicketRepository ticketRepository;

    @Inject
    OrderRepository orderRepository;

    @Inject
    TicketDetailRepository ticketDetailRepository;

    @Transactional
    public Orders createOrder(
            String name,
            String email,
            String phone,
            Integer age,
            String address,
            String gender,
            Integer ticketId,
            LocalDate startDate,
            LocalDate endDate,
            Integer quantity,
            Integer eventId) {

        // 1️⃣ Cek atau buat user baru
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.name = name;
                    newUser.email = email;
                    userRepository.persist(newUser);
                    return newUser;
                });

        // 2️⃣ Ambil tiket
        Ticket ticket = ticketRepository.findById(ticketId);
        if (ticket == null)
            throw new RuntimeException("Ticket not found");

        // Hitung total harga
        int totalPrice = (int) (ticket.getPrice() * quantity);
        // 3️⃣ Simpan ke tabel orders
        Orders order = new Orders();
        order.userId = user.id;
        order.eventId = eventId;
        order.ticketId = ticketId;
        order.quantity = quantity;
        order.price = totalPrice;
        order.status = "paid";
        order.order_date = LocalDate.now();

        orderRepository.persist(order);

        String orderStatus = "canceled";
        if (order.id != null) {
            orderStatus = "valid";
        }

        // 4️⃣ Simpan ke ticket_details
        TicketDetail detail = new TicketDetail();
        detail.orderId = order.id;
        detail.name = name;
        detail.email = email;
        detail.phone = phone;
        detail.age = age;
        detail.address = address;
        detail.gender = gender;
        detail.ticketStatus = orderStatus;
        detail.eventDate = startDate;

        ticketDetailRepository.persist(detail);

        return order;
    }

}
