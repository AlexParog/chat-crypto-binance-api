package com.application.chat.data.service;

import com.application.chat.data.entity.Chat;
import com.application.chat.data.repository.ChatRepository;
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
