package com.application.chat.service;

import com.application.chat.entity.Price;
import com.application.chat.entity.Ticker;
import com.application.chat.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для сущности "Цена"
 * {@link Price}
 *
 * @author alexanderbibik
 */
@Service
@AllArgsConstructor
public class PriceService {

    /**
     * Репозиторий сущности "Цена".
     */
    private final PriceRepository priceRepository;

    /**
     * Поиск последней записанной цены для определенного тикера.
     *
     * @param ticker тикер
     * @return если такой тикер существует, то вернется последняя записанная цена, если нет, то null
     */
    public Optional<Price> getLastPrice(Ticker ticker) {
        return priceRepository.findFirstByTickerOrderByTimeDesc(ticker);
    }

    /**
     * Очистка всех цен из базы до определенного времени.
     *
     * @param upTo ограничение по времени
     */
    public void clear(LocalDateTime upTo) {
        List<Price> toDelete = this.priceRepository.findAllByTimeLessThan(upTo);
        this.priceRepository.deleteAll(toDelete);
    }

    /**
     * Создание и сохранение нового объекта "Цена".
     *
     * @param ticker     тикер
     * @param priceValue значение цены
     * @param time       время изменения цены
     * @return новый объект "Цена".
     */
    public Price save(Ticker ticker, BigDecimal priceValue, LocalDateTime time) {
        Price price = new Price();
        price.setTicker(ticker);
        price.setValue(priceValue);
        price.setTime(time);
        price.setCreatedAt(LocalDateTime.now());

        return priceRepository.save(price);
    }
}
