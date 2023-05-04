package com.application.chat.data.repository;

import com.application.chat.data.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сущности "Бот"
 * {@link Bot}
 *
 * @author alexanderbibik
 */
@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {
}
