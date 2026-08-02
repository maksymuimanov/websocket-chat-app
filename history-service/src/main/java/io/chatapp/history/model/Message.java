package io.chatapp.history.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table("messages")
public class Message {
    @PrimaryKey
    private MessageKey key;
    private UUID senderId;
    private String body;
}
