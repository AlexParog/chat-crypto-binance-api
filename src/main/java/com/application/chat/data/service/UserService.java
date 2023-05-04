package com.application.chat.data.service;

import com.application.chat.data.entity.User;
import com.application.chat.data.repository.UserRepository;
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
