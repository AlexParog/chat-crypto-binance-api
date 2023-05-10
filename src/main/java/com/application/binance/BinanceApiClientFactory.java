package com.application.binance;

import com.application.binance.impl.BinanceApiRestClientImpl;

/**
 * Фабрика для создания объектов клиента Binance API.
 *
 * @author alexanderbibik
 */
public class BinanceApiClientFactory {

    /**
     * API-ключ.
     */
    private String apiKey;

    /**
     * Секретный ключ.
     */
    private String secret;

    /**
     * Создает новый экземпляр фабрики клиента Binance API.
     *
     * @param apiKey API-ключ
     * @param secret Секретный ключ
     */
    private BinanceApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * Создает и возвращает новый экземпляр фабрики клиента Binance API.
     *
     * @param apiKey API-ключ
     * @param secret Секретный ключ
     * @return фабрика клиента Binance API
     */
    public static BinanceApiClientFactory newInstance(String apiKey, String secret) {
        return new BinanceApiClientFactory(apiKey, secret);
    }

    /**
     * Создает и возвращает новый экземпляр фабрики клиента Binance API без аутентификации.
     *
     * @return фабрика клиента Binance API
     */
    public static BinanceApiClientFactory newInstance() {
        return new BinanceApiClientFactory(null, null);
    }

    /**
     * Создает и возвращает новый синхронный/блокирующий REST-клиент.
     *
     * @return REST-клиент Binance API
     */
    public BinanceApiRestClient newRestClient() {
        return new BinanceApiRestClientImpl(apiKey, secret);
    }

}
