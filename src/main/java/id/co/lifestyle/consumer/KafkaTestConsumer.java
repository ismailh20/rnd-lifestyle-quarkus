package id.co.lifestyle.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaTestConsumer {

    @Incoming("orders-in") // ini wajib
    public void consume(String message) {
        System.out.println("📥 Received from Kafka: " + message);
    }
}
