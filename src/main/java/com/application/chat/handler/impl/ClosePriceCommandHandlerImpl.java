package com.application.chat.handler.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.Candlestick;
import com.application.binance.domain.market.CandlestickInterval;
import com.application.chat.handler.CommandHandler;

import java.util.List;

/**
 * Обработчик команды "/closePrice".
 */
public class ClosePriceCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/closePrice".
     */
    private static final String COMMAND_CLOSE_PRICE = "/closePrice";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 3;

    /**
     * Индекс параметра символа в команде.
     */
    public static final int PARAM_SYMBOL = 1;

    /**
     * Индекс параметра времени в команде.
     */
    public static final int PARAM_TIME = 2;

    /**
     * REST-клиент для работы с API Binance.
     */
    private final BinanceApiRestClient binanceApiRestClient;

    /**
     * Конструктор класса.
     *
     * @param binanceApiRestClient REST-клиент для работы с API Binance
     */
    public ClosePriceCommandHandlerImpl(BinanceApiRestClient binanceApiRestClient) {
        this.binanceApiRestClient = binanceApiRestClient;
    }

    /**
     * Обрабатывает введенную команду "/closePrice".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /closePrice <SYMBOL> <TIME>";
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
            return "Не найдена цена закрытия свечного периода для данной валютной пары: " + symbol + " при интервале " +
                    interval.getIntervalId() + ". " + "Перейдите на биржу Binance для уточнения названия валютной пары.";

        }
        return "Цена закрытия свечного периода для " + symbol + ":" + candlesticks.get(0).getClose();
    }

    /**
     * Возвращает имя команды "/closePrice".
     *
     * @return имя команды "/closePrice"
     */
    @Override
    public String getCommandName() {
        return COMMAND_CLOSE_PRICE;
    }
}
