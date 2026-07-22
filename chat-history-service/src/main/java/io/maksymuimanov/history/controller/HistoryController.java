package io.maksymuimanov.history.controller;

import io.maksymuimanov.history.dto.ChatMessageDto;
import io.maksymuimanov.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/{version}/chats", version = "v1")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping("/{chatId}/messages")
    public Flux<ChatMessageDto> getChatMessages(@PathVariable UUID chatId, Pageable pageable) {
        return historyService.getMessages(chatId, pageable);
    }
}
