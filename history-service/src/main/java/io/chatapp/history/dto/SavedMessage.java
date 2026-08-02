package io.chatapp.history.dto;

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
