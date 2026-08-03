package io.chatapp.message.dto;

import java.time.Instant;
import java.util.UUID;

public record SavedMessage(
        UUID messageId,
        UUID chatId,
        UUID senderId,
        String body,
        Instant timestamp
) {
}
