package com.application.chat.data.repository;

import com.application.chat.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сущности "Пользователь"
 * {@link User}
 *
 * @author alexanderbibik
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
