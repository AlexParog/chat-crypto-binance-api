package com.application.chat.repository;

import com.application.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сущности "Чат"
 * {@link Chat}
 *
 * @author alexanderbibik
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
