package io.maksymuimanov.history.dto;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record ChatMessageDto(
        UUID messageId,
        UUID chatId,
        UUID senderId,
        String message,
        ZonedDateTime timestamp
) {
}
