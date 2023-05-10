package com.application.chat.service;

import com.application.chat.entity.Bot;
import com.application.chat.repository.BotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности "Бот"
 * {@link Bot}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class BotService {

    private final BotRepository botRepository;


}
