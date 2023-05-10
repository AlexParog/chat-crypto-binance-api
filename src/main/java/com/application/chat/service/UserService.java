package com.application.chat.service;

import com.application.chat.entity.User;
import com.application.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности "Пользователь"
 * {@link User}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
