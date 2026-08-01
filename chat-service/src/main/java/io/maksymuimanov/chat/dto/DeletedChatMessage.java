package io.maksymuimanov.chat.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DeletedChatMessage(
        UUID messageId,
        UUID chatId,
        UUID senderId
) {
}
