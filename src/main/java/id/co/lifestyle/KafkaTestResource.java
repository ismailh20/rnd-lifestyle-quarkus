package id.co.lifestyle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import jakarta.inject.Inject;

@Path("/test-kafka")
@Produces(MediaType.TEXT_PLAIN)
public class KafkaTestResource {

    @Inject
    @Channel("orders-out")
    Emitter<String> emitter;

    @POST
    @Path("/send/{msg}")
    public String sendMessage(@PathParam("msg") String msg) {
        emitter.send(msg);
        return "✅ Sent to Kafka: " + msg;
    }
}

