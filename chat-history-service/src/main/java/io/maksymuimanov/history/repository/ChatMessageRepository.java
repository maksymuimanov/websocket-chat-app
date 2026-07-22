package io.maksymuimanov.history.repository;

import io.maksymuimanov.history.entity.ChatMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ChatMessageRepository extends ReactiveCrudRepository<ChatMessage, UUID> {
    Flux<ChatMessage> findAllByChatIdOrderByTimestampDesc(UUID chatId, Pageable pageable);
}
