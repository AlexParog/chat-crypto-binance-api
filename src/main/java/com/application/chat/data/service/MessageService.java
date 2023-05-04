package com.application.chat.data.service;

import com.application.chat.data.entity.Message;
import com.application.chat.data.repository.MessageRepository;
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
