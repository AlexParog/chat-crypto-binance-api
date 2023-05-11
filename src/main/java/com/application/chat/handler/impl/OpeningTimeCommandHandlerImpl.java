package com.application.chat.handler.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.Candlestick;
import com.application.binance.domain.market.CandlestickInterval;
import com.application.chat.handler.CommandHandler;
import com.application.chat.utils.BinanceTimeConverter;

import java.util.List;

/**
 * Обработчик команды "/openingTime".
 */
public class OpeningTimeCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/openingTime".
     */
    private static final String COMMAND_OPENING_TIME = "/openingTime";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 3;

    /**
     * Индекс символа в массиве параметров команды.
     */
    public static final int PARAM_SYMBOL = 1;

    /**
     * Индекс времени в массиве параметров команды.
     */
    public static final int PARAM_TIME = 2;

    /**
     * Клиент для взаимодействия с Binance API.
     */
    private final BinanceApiRestClient binanceApiRestClient;

    /**
     * Создает новый экземпляр обработчика команды "/openingTime".
     *
     * @param binanceApiRestClient клиент для взаимодействия с Binance API
     */
    public OpeningTimeCommandHandlerImpl(BinanceApiRestClient binanceApiRestClient) {
        this.binanceApiRestClient = binanceApiRestClient;
    }

    /**
     * Обрабатывает введенную команду "/openingTime".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /openingTime <SYMBOL> <TIME>";
        }
        String symbol = params[PARAM_SYMBOL].toUpperCase();
        String time = params[PARAM_TIME];
        CandlestickInterval interval;

        try {
            interval = CandlestickInterval.valueOf(time);
        } catch (IllegalArgumentException e) {
            return """
                    Неверное значение времени. Пожалуйста, выберите один из доступных интервалов:
                    - час -> HOURLY
                    - 8 часов -> EIGHT_HOURLY
                    - 12 часов -> TWELVE_HOURLY
                    - день -> DAILY
                    - 3 дня -> THREE_DAILY
                    - неделя -> WEEKLY
                    - месяц -> MONTHLY""";
        }

        List<Candlestick> candlesticks = binanceApiRestClient.getCandlestickBars(symbol, interval);
        if (candlesticks == null || candlesticks.isEmpty()) {
            return "Не найдено время открытия свечного периода для данной валютной пары: " + symbol + " при интервале " +
                    interval.getIntervalId() + ". " + "Перейдите на биржу Binance для уточнения названия валютной пары.";

        }
        return "Время открытия свечного периода для " + symbol + ": " +
                BinanceTimeConverter.convertTimestampToString(candlesticks.get(0).getOpenTime());
    }

    /**
     * Возвращает имя команды "/openingTime".
     *
     * @return имя команды "/openingTime"
     */
    @Override
    public String getCommandName() {
        return COMMAND_OPENING_TIME;
    }
}
