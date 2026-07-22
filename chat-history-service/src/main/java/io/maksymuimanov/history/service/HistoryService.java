package io.maksymuimanov.history.service;

import io.maksymuimanov.history.dto.ChatMessageDto;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface HistoryService {
    Mono<ChatMessageDto> saveMessage(ChatMessageDto message);

    Flux<ChatMessageDto> getMessages(UUID chatId, Pageable pageable);

    Mono<Void> deleteMessage(UUID messageId);
}
