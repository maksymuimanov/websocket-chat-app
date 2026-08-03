package io.chatapp.message.consumer;

import io.chatapp.message.dto.DeletedMessage;
import io.chatapp.message.dto.SavedMessage;
import io.chatapp.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private final MessageService messageService;

    @KafkaListener(topics = "${app.topics.messages.save}")
    public void saveMessage(SavedMessage message) {
        log.info("Consumed message for saving: {}", message.messageId());
        messageService.saveMessage(message);
    }

    @KafkaListener(topics = "${app.topics.messages.delete}")
    public void deleteMessage(DeletedMessage message) {
        log.info("Consumed message for deleting: {}", message.messageId());
        messageService.deleteMessages(message);
    }
}
