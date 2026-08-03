package io.chatapp.message.dto;

import java.util.UUID;

public record MessageResponse(
        UUID senderId,
        String body
) {
}
