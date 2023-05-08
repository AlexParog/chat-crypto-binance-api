package com.application.chat.data.repository;

import com.application.chat.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для сущности "Пользователь"
 * {@link User}
 *
 * @author alexanderbibik
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Поиск пользователя по логину.
     *
     * @param login логин
     * @return если такой логин существует, то вернется пользователь, если нет, то null
     */
    Optional<User> findUserByLogin(String login);

    /**
     * Поиск пользователя по email.
     *
     * @param email электронная почта
     * @return если такой email существует, то вернется пользователь, если нет, то null
     */
    Optional<User> findUserByEmail(String email);

}
