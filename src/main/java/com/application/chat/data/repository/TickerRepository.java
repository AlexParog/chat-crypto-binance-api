package com.application.chat.data.repository;

import com.application.chat.data.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для сущности "Тикер"
 * {@link Ticker}
 *
 * @author alexanderbibik
 */
@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {

    /**
     * Поиска тикера по названию.
     *
     * @param name название тикера
     * @return если такое название существует, то вернется тикер, если нет, то null
     */
    Optional<Ticker> getByName(String name);

}
