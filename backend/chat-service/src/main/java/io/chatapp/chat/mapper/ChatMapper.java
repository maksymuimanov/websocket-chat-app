package io.chatapp.chat.mapper;

import io.chatapp.chat.dto.ChatRequest;
import io.chatapp.chat.dto.ChatResponse;
import io.chatapp.chat.model.Chat;
import io.chatapp.chat.model.ChatMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ChatMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Chat toChat(ChatRequest request);

    @Mapping(target = "id.chatId", ignore = true)
    @Mapping(target = "id.userId", source = "userId")
    @Mapping(target = "joinedAt", ignore = true)
    @Mapping(target = "chat", ignore = true)
    ChatMember toChatMember(ChatRequest.Member member);

    ChatResponse toChatResponse(Chat chat);

    @Mapping(target = "userId", source = "id.userId")
    ChatResponse.Member toMember(ChatMember chatMember);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Chat updateChat(@MappingTarget Chat chat, ChatRequest request);
}
