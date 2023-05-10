package com.application.binance.domain.general;

import lombok.Getter;
import lombok.Setter;

/**
 * Время сервера, на котором работает REST API Binance.
 *
 * @author alexanderbibik
 */
@Getter
@Setter
public class ServerTime {
    /**
     * Время сервера.
     */
    private Long serverTime;

    /**
     * Возвращает строковое представление времени сервера.
     *
     * @return Строковое представление времени сервера.
     */
    @Override
    public String toString() {
        return String.valueOf(serverTime);
    }
}
