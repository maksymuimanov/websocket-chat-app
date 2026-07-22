package io.maksymuimanov.history.consumer;

import io.maksymuimanov.history.dto.ChatMessageDto;
import io.maksymuimanov.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class HistoryConsumer {
    private final HistoryService historyService;

    @KafkaListener(topics = "${app.kafka.topics.message.save}")
    public void saveMessage(ChatMessageDto message) {
        log.info("Saving message by messageId: {}", message.messageId());
        historyService.saveMessage(message)
                .subscribe();
    }

    @KafkaListener(topics = "${app.kafka.topics.message.delete}")
    public void deleteMessage(UUID messageId) {
        log.info("Deleting message by messageId: {}", messageId);
        historyService.deleteMessage(messageId)
                .subscribe();
    }
}
