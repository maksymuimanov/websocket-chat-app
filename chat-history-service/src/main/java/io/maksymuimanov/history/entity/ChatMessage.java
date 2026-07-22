package io.maksymuimanov.history.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "chat_messages")
@CompoundIndex(name = "chat_id_sender_id_timestamp_idx", def = "{'chatId': 1, 'senderId': 1, 'timestamp': -1}")
public class ChatMessage {
    @Id
    private UUID messageId;
    private UUID chatId;
    private UUID senderId;
    private String message;
    private OffsetDateTime timestamp;
}
