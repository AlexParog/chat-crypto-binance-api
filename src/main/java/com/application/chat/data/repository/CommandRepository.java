package com.application.chat.data.repository;

import com.application.chat.data.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сущности "Команда"
 * {@link Command}
 *
 * @author alexanderbibik
 */
@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
}
