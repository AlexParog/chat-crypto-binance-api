package com.application.binance;

import com.application.binance.domain.market.*;

import java.util.List;

/**
 * Фасад Binance API, поддерживающий синхронный/блокирующий доступ к REST API Binance.
 *
 * @author alexanderbibik
 */
public interface BinanceApiRestClient {

    // General endpoints

    /**
     * Проверяет соединение с REST API.
     */
    void ping();

    /**
     * Получает время сервера.
     *
     * @return время сервера в миллисекундах
     */
    Long getServerTime();

    // Market Data endpoints

    /**
     * Получает стакан заказов для указанного символа.
     *
     * @param symbol символ тикера (например, ETHBTC)
     * @param limit  глубина стакана (максимум 100)
     * @return стакан заказов для указанного символа
     */
    OrderBook getOrderBook(String symbol, Integer limit);

    /**
     * Получает сжатые, агрегированные сделки. Сделки, которые были исполнены одновременно, из одного ордера,
     * с одной и той же ценой, имеют суммарный объем.
     * <p>
     * Если указаны оба <code>startTime</code> и <code>endTime</code>, <code>limit</code> не должен быть указан,
     * а разница между <code>startTime</code> и <code>endTime</code> должна быть менее 24 часов.
     *
     * @param symbol    символ для агрегации (обязательный параметр)
     * @param fromId    ID, с которого следует получать агрегированные сделки, включительно (необязательный параметр)
     * @param limit     по умолчанию 500, максимум 500 (необязательный параметр)
     * @param startTime временная метка начала для получения агрегированных сделок, включительно (необязательный параметр)
     * @param endTime   временная метка окончания для получения агрегированных сделок, включительно (необязательный параметр)
     * @return список агрегированных сделок для указанного символа
     */
    List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime);

    /**
     * Возвращает наиболее последние агрегированные сделки для указанного символа.
     *
     * @param symbol символ для агрегации
     * @return список наиболее последних агрегированных сделок для указанного символа
     * @see #getAggTrades(String, String, Integer, Long, Long)
     */
    List<AggTrade> getAggTrades(String symbol);

    /**
     * Свечи (candlestick) для указанного символа. Каждая свеча уникально идентифицируется временем открытия.
     *
     * @param symbol    символ для агрегации (обязательный параметр)
     * @param interval  интервал свечи (обязательный параметр)
     * @param limit     по умолчанию 500; максимум 500 (необязательный параметр)
     * @param startTime временная метка начала для получения свечей, включительно (необязательный параметр)
     * @param endTime   временная метка окончания для получения свечей, включительно (необязательный параметр)
     * @return свечи (candlestick) для указанного символа и интервала
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Свечи (candlestick) для указанного символа. Каждая свеча уникально идентифицируется временем открытия.
     *
     * @param symbol   символ для агрегации (обязательный параметр)
     * @param interval интервал свечи (обязательный параметр)
     * @return свечи (candlestick) для указанного символа и интервала
     * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval);

    /**
     * Получает статистику изменения цены за 24 часа.
     *
     * @param symbol символ тикера (например, ETHBTC)
     * @return статистика изменения цены за 24 часа для указанного символа
     */
    TickerStatistics get24HrPriceStatistics(String symbol);

    /**
     * Получает последнюю цену для всех символов.
     *
     * @return список последних цен для всех символов
     */
    List<TickerPrice> getAllPrices();

}
