package io.chatapp.history.consumer;

import io.chatapp.history.dto.SavedMessage;
import io.chatapp.history.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private final MessageService messageService;

    @KafkaListener(topics = "${chat.topics.history.save}")
    public void saveMessage(SavedMessage message) {
        log.info("Consumed message for saving: {}", message.messageId());
        messageService.saveMessage(message);
    }
}
