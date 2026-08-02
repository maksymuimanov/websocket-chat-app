package io.chatapp.history.mapper;

import io.chatapp.history.dto.MessageResponse;
import io.chatapp.history.dto.SavedMessage;
import io.chatapp.history.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface MessageMapper {
    @Mapping(target = "key.messageId", source = "messageId")
    @Mapping(target = "key.chatId", source = "chatId")
    @Mapping(target = "key.timestamp", source = "timestamp")
    Message toMessage(SavedMessage savedMessage);

    MessageResponse toMessageResponse(Message message);
}
