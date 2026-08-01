package io.maksymuimanov.chat.service;

import io.maksymuimanov.chat.config.ChatMessageTopicProperties;
import io.maksymuimanov.chat.dto.SavedChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ChatMessagePublisherImpl implements ChatMessagePublisher {
    private final KafkaTemplate<UUID, SavedChatMessage> kafkaTemplate;
    private final ChatMessageTopicProperties topicProperties;

    @Override
    public void sendMessage(SavedChatMessage message) {
        kafkaTemplate.send(topicProperties.historySave(), message.messageId(), message);
        kafkaTemplate.send(topicProperties.syncSave(), message.messageId(), message);
    }
}
