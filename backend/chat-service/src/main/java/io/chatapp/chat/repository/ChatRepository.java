package io.chatapp.chat.repository;

import io.chatapp.chat.model.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    @Query("SELECT c FROM Chat c JOIN ChatMember cm ON c.id = cm.id.chatId WHERE cm.id.userId = :userId")
    Page<Chat> findAllByUserId(UUID userId, Pageable pageable);
}
