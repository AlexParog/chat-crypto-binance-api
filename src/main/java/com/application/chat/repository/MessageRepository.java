package com.application.chat.repository;

import com.application.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сущности "Сообщение"
 * {@link Message}
 *
 * @author alexanderbibik
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
