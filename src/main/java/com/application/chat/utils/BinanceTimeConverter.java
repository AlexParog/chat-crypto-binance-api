package com.application.chat.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class BinanceTimeConverter {
    /**
     * Преобразует время в миллисекундах с Binance API в строковое значение.
     *
     * @param timestamp Время в миллисекундах
     * @return Строковое представление времени
     */
    public static String convertTimestampToString(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return localDateTime.format(formatter);
    }
}
