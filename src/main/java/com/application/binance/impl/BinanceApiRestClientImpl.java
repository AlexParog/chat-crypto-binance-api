package com.application.binance.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.*;

import java.util.List;

import static com.application.binance.impl.BinanceApiServiceGenerator.createService;
import static com.application.binance.impl.BinanceApiServiceGenerator.executeSync;

/**
 * Реализация REST API Binance с использованием Retrofit с синхронными/блокирующими вызовами методов.
 */
public class BinanceApiRestClientImpl implements BinanceApiRestClient {

    /**
     * Интерфейс для маппинга URL-адресов и настройки безопасности конечных точек Binance REST API.
     */
    private final BinanceApiService binanceApiService;

    /**
     * Создает новый экземпляр класса BinanceApiRestClientImpl.
     *
     * @param apiKey ключ API
     * @param secret секретный ключ
     */
    public BinanceApiRestClientImpl(String apiKey, String secret) {
        binanceApiService = createService(BinanceApiService.class, apiKey, secret);
    }

    // General endpoints

    /**
     * Проверяет связь с сервером Binance.
     */
    @Override
    public void ping() {
        executeSync(binanceApiService.ping());
    }

    /**
     * Получает текущее время сервера Binance.
     *
     * @return Время сервера в формате UNIX timestamp (в миллисекундах).
     */
    @Override
    public Long getServerTime() {
        return executeSync(binanceApiService.getServerTime()).getServerTime();
    }

    // Market Data endpoints

    /**
     * Получает ордерную книгу по заданной валютной паре и ограничению количества ордеров.
     *
     * @param symbol валютная пара
     * @param limit  ограничение количества ордеров
     * @return объект ордерной книги
     */
    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }

    /**
     * Получает список агрегированных сделок по заданной валютной паре.
     *
     * @param symbol    валютная пара
     * @param fromId    идентификатор сделки, начиная с которого нужно получить данные
     * @param limit     ограничение количества сделок
     * @param startTime время начала периода
     * @param endTime   время окончания периода
     * @return список агрегированных сделок
     */
    @Override
    public List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getAggTrades(symbol, fromId, limit, startTime, endTime));
    }

    /**
     * Получает список агрегированных сделок по заданной валютной паре.
     *
     * @param symbol валютная пара
     * @return список агрегированных сделок
     */
    @Override
    public List<AggTrade> getAggTrades(String symbol) {
        return getAggTrades(symbol, null, null, null, null);
    }

    /**
     * Получает список свечей (графиков) по заданной валютной паре, интервалу, ограничению количества свечей,
     * времени начала и времени окончания.
     *
     * @param symbol    валютная пара
     * @param interval  интервал свечей
     * @param limit     ограничение количества свечей
     * @param startTime время начала периода
     * @param endTime   время окончания периода
     * @return список свечей (графиков)
     */
    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval,
                                                Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getCandlestickBars(symbol, interval.getIntervalId(),
                limit, startTime, endTime));
    }

    /**
     * Получает список свечей (графиков) по заданной валютной паре, интервалу.
     *
     * @param symbol   валютная пара
     * @param interval интервал свечей
     * @return список свечей (графиков)
     */
    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval) {
        return getCandlestickBars(symbol, interval, null, null, null);
    }

    /**
     * Получает статистику цен за последние 24 часа по заданной валютной паре.
     *
     * @param symbol валютная пара
     * @return статистика цен за последние 24 часа
     */
    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return executeSync(binanceApiService.get24HrPriceStatistics(symbol));
    }

    /**
     * Получает последнюю цену по валютной паре.
     *
     * @param symbol название валютной пары
     * @return цена валютной пары
     */
    @Override
    public TickerPrice getTickerPrice(String symbol) {
        return executeSync(binanceApiService.getTickerPrice(symbol));
    }

    /**
     * Получает список последних цен по всем валютным парам.
     *
     * @return список последних цен
     */
    @Override
    public List<TickerPrice> getAllPrices() {
        return executeSync(binanceApiService.getLatestPrices());
    }

}
