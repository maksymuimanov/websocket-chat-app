package io.chatapp.message.mapper;

import io.chatapp.message.dto.MessageResponse;
import io.chatapp.message.dto.SavedMessage;
import io.chatapp.message.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface MessageMapper {
    @Mapping(target = "key.id", source = "messageId")
    @Mapping(target = "key.chatId", source = "chatId")
    @Mapping(target = "key.timestamp", source = "timestamp")
    Message toMessage(SavedMessage savedMessage);

    MessageResponse toMessageResponse(Message message);
}
