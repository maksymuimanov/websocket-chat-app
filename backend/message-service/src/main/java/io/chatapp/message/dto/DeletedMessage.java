package io.chatapp.message.dto;

import java.util.UUID;

public record DeletedMessage(
        UUID messageId
) {
}
