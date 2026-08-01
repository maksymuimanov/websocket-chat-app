package io.maksymuimanov.chat.service;

import io.maksymuimanov.chat.dto.SavedChatMessage;

public interface ChatMessagePublisher {
    void sendMessage(SavedChatMessage message);
}
