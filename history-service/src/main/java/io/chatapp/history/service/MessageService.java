package io.chatapp.history.service;

import io.chatapp.history.dto.MessageResponse;
import io.chatapp.history.dto.SavedMessage;
import io.chatapp.history.mapper.MessageMapper;
import io.chatapp.history.model.Message;
import io.chatapp.history.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageResponse saveMessage(SavedMessage message) {
        Message mappedMessage = messageMapper.toMessage(message);
        messageRepository.save(mappedMessage);
        return messageMapper.toMessageResponse(mappedMessage);
    }

    public Page<MessageResponse> getMessages(UUID chatId, Pageable pageable) {
        return messageRepository.findAllByKeyChatId(chatId, pageable)
                .map(messageMapper::toMessageResponse);
    }
}
