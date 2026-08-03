package io.chatapp.chat.service;

import io.chatapp.chat.dto.ChatRequest;
import io.chatapp.chat.dto.ChatResponse;
import io.chatapp.chat.exception.ChatNotFoundException;
import io.chatapp.chat.mapper.ChatMapper;
import io.chatapp.chat.model.Chat;
import io.chatapp.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    @Transactional
    public ChatResponse createChat(ChatRequest request) {
        Chat chat = chatMapper.toChat(request);
        chatRepository.save(chat);
        return chatMapper.toChatResponse(chat);
    }

    @Transactional(readOnly = true)
    public Page<ChatResponse> getUserChats(UUID userId, Pageable pageable) {
        return chatRepository.findAllByUserId(userId, pageable)
                .map(chatMapper::toChatResponse);
    }

    @Transactional(readOnly = true)
    public ChatResponse getChat(UUID chatId) {
        return chatRepository.findById(chatId)
                .map(chatMapper::toChatResponse)
                .orElseThrow(() -> ChatNotFoundException.notFound(chatId));
    }

    @Transactional
    public ChatResponse updateChat(UUID chatId, ChatRequest request) {
        return chatRepository.findById(chatId)
                .map(chat -> chatMapper.updateChat(chat, request))
                .map(chatRepository::save)
                .map(chatMapper::toChatResponse)
                .orElseThrow(() -> ChatNotFoundException.notFound(chatId));
    }

    @Transactional
    public void deleteChat(UUID chatId) {
        chatRepository.deleteById(chatId);
    }
}
