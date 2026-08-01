package io.maksymuimanov.history.mapper;

import io.maksymuimanov.history.dto.SavedChatMessage;
import io.maksymuimanov.history.entity.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ChatMessageMapper {
    @Mapping(target = "timestamp", ignore = true)
    ChatMessage toEntity(SavedChatMessage message);

    SavedChatMessage toDto(ChatMessage message);
}
