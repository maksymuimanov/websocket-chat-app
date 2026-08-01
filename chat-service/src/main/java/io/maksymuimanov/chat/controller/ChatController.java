package io.maksymuimanov.chat.controller;

import io.maksymuimanov.chat.dto.SavedChatMessage;
import io.maksymuimanov.chat.service.ChatMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatMessagePublisher chatMessagePublisher;

    @MessageMapping("/chat")
    public void sendMessage(SavedChatMessage message) {
        chatMessagePublisher.sendMessage(message);
    }
}
