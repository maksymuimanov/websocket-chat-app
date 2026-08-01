package io.maksymuimanov.chat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chat.message.topic")
public record ChatMessageTopicProperties(
        String syncSave,
        String historySave
) {
}
