package com.application.chat.data.service;

import com.application.chat.data.entity.Command;
import com.application.chat.data.repository.CommandRepository;
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
