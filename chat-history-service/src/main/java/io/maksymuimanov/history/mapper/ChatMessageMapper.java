package io.maksymuimanov.history.mapper;

import io.maksymuimanov.history.dto.ChatMessageDto;
import io.maksymuimanov.history.entity.ChatMessage;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ChatMessageMapper {
    ChatMessage toEntity(ChatMessageDto message);

    ChatMessageDto toDto(ChatMessage message);
}
