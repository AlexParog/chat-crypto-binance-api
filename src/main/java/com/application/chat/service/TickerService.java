package com.application.chat.service;

import com.application.chat.entity.Ticker;
import com.application.chat.repository.TickerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Сервис для сущности "Цена"
 * {@link Ticker}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class TickerService {

    /**
     * Репозиторий сущности "Тикер".
     */
    private final TickerRepository tickerRepository;

    /**
     * Создание и сохранение нового объекта "Тикер".
     *
     * @param tickerName название тикера
     * @return новый объект "Тикер"
     */
    public Ticker save(String tickerName) {
        Ticker ticker = new Ticker();
        ticker.setName(tickerName);
        ticker.setCreatedAt(LocalDateTime.now());
        return tickerRepository.save(ticker);
    }

    /**
     * Поиска тикера по названию.
     *
     * @param tickerName название тикера
     * @return если такой тикер существует в БД, то вернем тикер, если нет, то сохраним тикер в БД
     */
    public Ticker getTickerByName(String tickerName) {
        return tickerRepository.getByName(tickerName).orElse(save(tickerName));

    }
}
