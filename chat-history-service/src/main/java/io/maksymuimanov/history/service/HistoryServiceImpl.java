package io.maksymuimanov.history.service;

import io.maksymuimanov.history.dto.ChatMessageDto;
import io.maksymuimanov.history.entity.ChatMessage;
import io.maksymuimanov.history.mapper.ChatMessageMapper;
import io.maksymuimanov.history.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final ChatMessageRepository messageRepository;
    private final ChatMessageMapper messageMapper;

    @Override
    @Transactional
    public Mono<ChatMessageDto> saveMessage(ChatMessageDto message) {
        ChatMessage entity = messageMapper.toEntity(message);
        return messageRepository.save(entity)
                .map(messageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ChatMessageDto> getMessages(UUID chatId, Pageable pageable) {
        return messageRepository.findAllByChatId(chatId, pageable)
                .map(messageMapper::toDto);
    }

    @Override
    @Transactional
    public Mono<Void> deleteMessage(UUID messageId) {
        return messageRepository.deleteById(messageId);
    }
}
