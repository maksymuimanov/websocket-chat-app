package io.chatapp.history.controller;

import io.chatapp.history.dto.MessageResponse;
import io.chatapp.history.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/{version}/chats", version = "1")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/{chatId}/messages")
    public PagedModel<MessageResponse> getMessages(@PathVariable UUID chatId, Pageable pageable) {
        return new PagedModel<>(messageService.getMessages(chatId, pageable));
    }
}
