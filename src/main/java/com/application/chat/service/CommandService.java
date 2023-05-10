package com.application.chat.service;

import com.application.chat.entity.Command;
import com.application.chat.repository.CommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности "Команда"
 * {@link Command}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class CommandService {

    private final CommandRepository commandRepository;
}
