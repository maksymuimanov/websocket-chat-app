package io.maksymuimanov.history.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SavedChatMessage(
        UUID messageId,
        UUID chatId,
        UUID senderId,
        String content
) {
}
