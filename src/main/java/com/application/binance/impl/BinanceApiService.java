package com.application.binance.impl;

import com.application.binance.domain.general.ServerTime;
import com.application.binance.domain.market.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Интерфейс для маппинга URL-адресов Binance REST API.
 *
 * @author alexanderbibik
 */
public interface BinanceApiService {

    // General endpoints

    /**
     * Выполняет запрос ping для проверки доступности сервера.
     *
     * @return объект типа Call<Void>
     */
    @GET("/api/v1/ping")
    Call<Void> ping();

    /**
     * Получает время сервера Binance.
     *
     * @return объект типа Call<ServerTime>
     */
    @GET("/api/v1/time")
    Call<ServerTime> getServerTime();

    // Market data endpoints

    /**
     * Получает стакан ордеров (Order Book) по заданной валютной паре и ограничению количества ордеров.
     *
     * @param symbol валютная пара
     * @param limit  ограничение количества ордеров
     * @return объект типа Call<OrderBook>
     */
    @GET("/api/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    /**
     * Получает список сгруппированных сделок (AggTrades) по заданной валютной паре, начиная с указанного идентификатора сделки,
     * с ограничением количества сделок, в указанном временном диапазоне.
     *
     * @param symbol    валютная пара
     * @param fromId    идентификатор сделки, начиная с которого нужно получить сгруппированные сделки (может быть null)
     * @param limit     ограничение количества сделок (может быть null)
     * @param startTime время начала диапазона (может быть null)
     * @param endTime   время окончания диапазона (может быть null)
     * @return список сгруппированных сделок {@link AggTrade}
     */
    @GET("/api/v1/aggTrades")
    Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    /**
     * Получает список свечей (Candlestick) по заданной валютной паре, интервалу, ограничению количества свечей,
     * времени начала и времени окончания.
     *
     * @param symbol    валютная пара
     * @param interval  интервал свечей
     * @param limit     ограничение количества свечей
     * @param startTime время начала периода
     * @param endTime   время окончания периода
     * @return список свечей {@link Candlestick}
     */
    @GET("/api/v1/klines")
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                               @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    /**
     * Получает статистику цен за последние 24 часа для указанного символа.
     *
     * @param symbol символ, для которого нужно получить статистику цен
     * @return объект {@link Call}, представляющий асинхронный запрос на получение данных {@link TickerStatistics}
     */
    @GET("/api/v1/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    /**
     * Получает последние цену для определенного тикера.
     *
     * @return объект {@link Call}, представляющий асинхронный запрос на получение списка данных {@link TickerPrice}
     */
    @GET("/api/v1/ticker/price")
    Call<TickerPrice> getTickerPrice(@Query("symbol") String symbol);

    /**
     * Получает последние цены для всех валютных пар.
     *
     * @return объект {@link Call}, представляющий асинхронный запрос на получение списка данных {@link TickerPrice}
     */
    @GET("/api/v1/ticker/allPrices")
    Call<List<TickerPrice>> getLatestPrices();

}
