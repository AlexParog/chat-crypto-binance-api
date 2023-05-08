package com.application.chat.data.repository;

import com.application.chat.data.entity.Price;
import com.application.chat.data.entity.PriceId;
import com.application.chat.data.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для сущности "Цена"
 * {@link Price}
 *
 * @author alexanderbibik
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {

    /**
     * Поиск всех цен до определенного времени.
     *
     * @param time ограничение по времени
     * @return список цен
     */
    List<Price> findAllByTimeLessThan(LocalDateTime time);

    /**
     * Поиск последней записанной цены для определенного тикера.
     *
     * @param ticker тикер
     * @return если такой тикер существует, то вернется последняя записанная цена, если нет, то null
     */
    Optional<Price> findFirstByTickerOrderByTimeDesc(Ticker ticker);

}
