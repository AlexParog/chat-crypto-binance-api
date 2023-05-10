package com.application.chat.service;

import com.application.chat.entity.Chat;
import com.application.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности "Чат"
 * {@link Chat}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

}
