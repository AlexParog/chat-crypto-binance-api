package com.application.chat.data.service;

import com.application.chat.data.entity.Bot;
import com.application.chat.data.repository.BotRepository;
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
