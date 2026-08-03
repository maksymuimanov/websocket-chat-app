package io.chatapp.chat.controller;

import io.chatapp.chat.dto.ChatRequest;
import io.chatapp.chat.dto.ChatResponse;
import io.chatapp.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/{version}/chats", version = "1")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatResponse> createChat(@RequestBody ChatRequest request) {
        ChatResponse chat = chatService.createChat(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(chat.id())
                        .toUri())
                .build();
    }

    @GetMapping(params = "userId")
    public PagedModel<ChatResponse> getUserChats(@RequestParam UUID userId, Pageable pageable) {
        return new PagedModel<>(chatService.getUserChats(userId, pageable));
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<ChatResponse> getChat(@PathVariable UUID chatId) {
        return ResponseEntity.ok(chatService.getChat(chatId));
    }

    @PutMapping("/{chatId}")
    public ResponseEntity<ChatResponse> updateChat(@PathVariable UUID chatId, @RequestBody ChatRequest request) {
        return ResponseEntity.ok(chatService.updateChat(chatId, request));
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable UUID chatId) {
        chatService.deleteChat(chatId);
        return ResponseEntity.noContent().build();
    }
}
