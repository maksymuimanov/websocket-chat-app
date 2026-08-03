package io.chatapp.chat.dto;

import io.chatapp.chat.model.ChatType;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ChatRequest(
        ChatType type,
        List<Member> members
) {
    @Builder
    public record Member(
            UUID userId
    ) {
    }
}
