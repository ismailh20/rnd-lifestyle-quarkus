package id.co.lifestyle.controller;

import id.co.lifestyle.model.Orders;
import id.co.lifestyle.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Map;

@Path("/api/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    OrderService orderService;

    @POST
    public Response createOrder(Map<String, Object> body) {
        //Order Request Body Parsing
        Integer quantity = (Integer) body.getOrDefault("quantity", 1);
        Integer ticketId = (Integer) body.get("ticketId");
        Integer eventId = (Integer) body.get("eventId");

        //TiketDetail Request Body Parsing
        String name = (String) body.get("name");
        String email = (String) body.get("email");
        String phone = (String) body.get("phone");
        Integer age = (Integer) body.get("age");
        String address = (String) body.get("address");
        String gender = (String) body.get("gender");

        LocalDate startDate = LocalDate.parse((String) body.get("startDate"));
        LocalDate endDate = LocalDate.parse((String) body.get("endDate"));

        Orders order = orderService.createOrder(
                name,
                email,
                phone,
                age,
                address,
                gender,
                ticketId,
                startDate,
                endDate,
                quantity,
                eventId
        );

        return Response.ok(Map.of(
                "bookingDetails", Map.of(
                        "ticketId", order.ticketId,
                        "orderId", order.id,
                        "totalPrice", order.price,
                        "days", order.order_date)))
                .build();
    }
}
