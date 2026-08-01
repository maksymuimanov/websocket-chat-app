package io.maksymuimanov.history.consumer;

import io.maksymuimanov.history.dto.SavedChatMessage;
import io.maksymuimanov.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HistoryConsumer {
    private final HistoryService historyService;

    @KafkaListener(topics = "${chat.message.topic.history-save}")
    public void saveMessage(SavedChatMessage message) {
        log.info("Saving message by messageId: {}", message.messageId());
        historyService.saveMessage(message)
                .subscribe();
    }
}
