package com.kafka.chat.kafka;

import com.kafka.chat.kafka.config.KafkaConstants;
import com.kafka.chat.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    SimpMessagingTemplate template;

    @Autowired
    public MessageConsumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener..");
        template.convertAndSend("/topic/group", message);
    }
}
