package com.application.chat.data.controller;

import com.application.chat.data.service.PriceService;
import com.application.chat.data.service.TickerService;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class BinanceFetcherJob {

    private TickerService tickerService;
    private PriceService priceService;
    private BinanceApiRestClient binanceApiRestClient;

    @Scheduled(fixedRate = 60000)
    private void call() {
        // получение все криптовалют и цен
        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();
        // Получение исторических данных за день (1 день = 24 часа) для BTC/USDT
        // научиться парсить и красиво выводить
        List<Candlestick> candlesticks = binanceApiRestClient.getCandlestickBars("BTCUSDT", CandlestickInterval.MONTHLY);

        // Вывод цен закрытия каждого свечного периода за день
        /*for (Candlestick candlestick : candlesticks) {
            System.out.println(candlestick.getClose());
        }*/

        // TODO: Получение текущей цены
        // TickerPrice tickerPrice = binanceApiRestClient.getTickerPrice("BTCUSDT");
        // BigDecimal price = new BigDecimal(tickerPrice.getPrice());

        // Получение свечных данных за последний месяц
        // KlinesRequest request = new KlinesRequest("BTCUSDT", KlineInterval.MONTHLY);
        // List<Kline> klines = client.getKlines(request);

        // Получение статистики торгов за последние 24 часа
        /*TickerStatistics tickerStatistics = binanceApiRestClient.get24HrPriceStatistics("BTCUSDT");
        BigDecimal volume = new BigDecimal(tickerStatistics.getVolume());
        System.out.println("volume = " + volume);*/


        /*tickerPrices.forEach(tickerPrice -> {
            String tickerName = null;
            BigDecimal price = BigDecimal.ZERO;
            try {
                tickerName = tickerPrice.getSymbol();
                Ticker ticker = tickerService.get(tickerName);
                price = new BigDecimal(tickerPrice.getPrice());

                priceService.save(ticker, price, LocalDateTime.now());
            } catch (Exception e) {
                log.error("Ticker: {}, Price: {}, Exception: {}", tickerName, price, e.getMessage());
            }
        });*/
    }


}
