package io.chatapp.chat.dto;

import io.chatapp.chat.model.ChatType;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record ChatResponse(
        UUID id,
        ChatType type,
        Instant createdAt,
        List<Member> members
) {
    @Builder
    public record Member(
            UUID userId,
            Instant joinedAt
    ) {
    }
}
