package com.application.chat.data.provider;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Класс, хранящий API-ключ и секртный ключ Binance API.
 *
 * @author alexanderbibik
 */
@Component
@Getter
public class BinanceSettingsProvider {

    /**
     * API-ключ.
     */
    @Value("${binance.api.key}")
    private String apiKey;

    /**
     * Секретный ключ.
     */
    @Value("${binance.api.secret}")
    private String secretKey;

}
