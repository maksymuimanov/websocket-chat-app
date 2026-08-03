package io.chatapp.chat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChatNotFoundException extends RuntimeException {
    public static ChatNotFoundException notFound(UUID chatId) {
        return new ChatNotFoundException("Chat with id " + chatId + " not found");
    }

    private ChatNotFoundException(String message) {
        super(message);
    }
}
