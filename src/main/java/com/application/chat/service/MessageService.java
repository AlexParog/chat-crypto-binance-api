package com.application.chat.service;

import com.application.chat.entity.Message;
import com.application.chat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности "Сообщение"
 * {@link Message}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
}
