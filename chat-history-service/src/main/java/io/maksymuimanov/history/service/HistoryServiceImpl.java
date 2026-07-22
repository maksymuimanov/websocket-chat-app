package io.maksymuimanov.history.service;

import io.maksymuimanov.history.dto.ChatMessageDto;
import io.maksymuimanov.history.entity.ChatMessage;
import io.maksymuimanov.history.mapper.ChatMessageMapper;
import io.maksymuimanov.history.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final ChatMessageRepository messageRepository;
    private final ChatMessageMapper messageMapper;

    @Override
    public Mono<ChatMessageDto> saveMessage(ChatMessageDto message) {
        log.info("Saving message by messageId: {}", message.messageId());
        ChatMessage entity = messageMapper.toEntity(message);
        return messageRepository.save(entity)
                .map(messageMapper::toDto)
                .doOnNext(savedMessage -> log.info("Message saved by messageId: {}", savedMessage.messageId()))
                .doOnError(error -> log.error("Error saving message: {}", error.getMessage()));
    }

    @Override
    public Flux<ChatMessageDto> getMessages(UUID chatId, Pageable pageable) {
        log.info("Getting messages for chatId: {}", chatId);
        return messageRepository.findAllByChatIdOrderByTimestampDesc(chatId, pageable)
                .map(messageMapper::toDto);
    }

    @Override
    public Mono<Void> deleteMessage(UUID messageId) {
        log.info("Deleting message by messageId: {}", messageId);
        return messageRepository.deleteById(messageId)
                .doOnSuccess(_ -> log.info("Message deleted by messageId: {}", messageId))
                .doOnError(error -> log.error("Error deleting message: {}", error.getMessage()));
    }
}
