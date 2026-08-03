package io.chatapp.message.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.Instant;
import java.util.UUID;

@Data
@PrimaryKeyClass
public class MessageKey {
    @PrimaryKeyColumn(
            name = "message_id",
            ordinal = 1,
            type = PrimaryKeyType.CLUSTERED
    )
    private UUID id;

    @PrimaryKeyColumn(
            name = "chat_id",
            type = PrimaryKeyType.PARTITIONED
    )
    private UUID chatId;

    @PrimaryKeyColumn(
            name = "timestamp",
            ordinal = 0,
            type = PrimaryKeyType.CLUSTERED
    )
    private Instant timestamp;
}
