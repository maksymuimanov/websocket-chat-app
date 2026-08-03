package io.chatapp.message.service;

import io.chatapp.message.dto.MessageResponse;
import io.chatapp.message.dto.SavedMessage;
import io.chatapp.message.mapper.MessageMapper;
import io.chatapp.message.model.Message;
import io.chatapp.message.repository.MessageRepository;
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
