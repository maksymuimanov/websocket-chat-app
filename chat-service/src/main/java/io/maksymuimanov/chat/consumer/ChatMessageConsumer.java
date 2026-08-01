package io.maksymuimanov.chat.consumer;

import io.maksymuimanov.chat.dto.SavedChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatMessageConsumer {
    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "${chat.message.topic.sync-save}")
    public void syncSaveMessage(SavedChatMessage message) {
        messagingTemplate.convertAndSend("/topic/messages/" + message.chatId(), message);
    }
}
