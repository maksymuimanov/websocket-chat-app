package io.chatapp.history.repository;

import io.chatapp.history.model.Message;
import io.chatapp.history.model.MessageKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MessageRepository extends CassandraRepository<Message, MessageKey> {
    Page<Message> findAllByKeyChatId(UUID chatId, Pageable pageable);
}
