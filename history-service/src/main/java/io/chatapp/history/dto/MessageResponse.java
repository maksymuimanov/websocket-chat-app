package io.chatapp.history.dto;

import java.util.UUID;

public record MessageResponse(
        UUID senderId,
        String body
) {
}
