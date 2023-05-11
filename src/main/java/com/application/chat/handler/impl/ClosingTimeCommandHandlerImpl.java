package com.application.chat.handler.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.Candlestick;
import com.application.binance.domain.market.CandlestickInterval;
import com.application.chat.handler.CommandHandler;
import com.application.chat.utils.BinanceTimeConverter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Обработчик команды "/closingTime".
 */
@Component
public class ClosingTimeCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/closingTime".
     */
    private static final String COMMAND_CLOSING_TIME = "/closingTime";

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
    public ClosingTimeCommandHandlerImpl(BinanceApiRestClient binanceApiRestClient) {
        this.binanceApiRestClient = binanceApiRestClient;
    }

    /**
     * Обрабатывает введенную команду "/closingTime".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /closingTime <SYMBOL> <TIME>";
        }
        String symbol = params[PARAM_SYMBOL].toUpperCase();
        String time = params[PARAM_TIME];
        CandlestickInterval interval;

        try {
            interval = CandlestickInterval.valueOf(time.toUpperCase());
        } catch (IllegalArgumentException e) {
            return """
                    Неверное значение времени. Пожалуйста, выберите один из доступных интервалов:
                    - час -> 1h
                    - 8 часов -> 8h
                    - 12 часов -> 12h
                    - день -> 1d
                    - 3 дня -> 3d
                    - неделя -> 1w
                    - месяц -> 1M)""";
        }

        List<Candlestick> candlesticks = binanceApiRestClient.getCandlestickBars(symbol, interval);
        if (candlesticks == null || candlesticks.isEmpty()) {
            return "Не найдена время закрытия для данной валютной пары: " + symbol + " при интервале " +
                    interval.getIntervalId() + ". " + "Перейдите на биржу Binance для уточнения названия валютной пары.";

        }
        return BinanceTimeConverter.convertTimestampToString(candlesticks.get(0).getCloseTime());
    }

    /**
     * Возвращает имя команды "/closingTime".
     *
     * @return имя команды "/closingTime"
     */
    @Override
    public String getCommandName() {
        return COMMAND_CLOSING_TIME;
    }
}
