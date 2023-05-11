package com.application.chat.repository;

import com.application.chat.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для сущности "Команда"
 * {@link Command}
 *
 * @author alexanderbibik
 */
@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

    /**
     * Поиск команды по названию.
     *
     * @param commandName название команды
     * @return команда
     */
    Optional<Command> getCommandByCommandName(String commandName);
}
