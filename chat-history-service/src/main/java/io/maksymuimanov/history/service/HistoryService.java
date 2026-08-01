package io.maksymuimanov.history.service;

import io.maksymuimanov.history.dto.SavedChatMessage;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface HistoryService {
    Mono<SavedChatMessage> saveMessage(SavedChatMessage message);

    Flux<SavedChatMessage> getMessages(UUID chatId, Pageable pageable);

    Mono<Void> deleteMessage(SavedChatMessage message);
}
