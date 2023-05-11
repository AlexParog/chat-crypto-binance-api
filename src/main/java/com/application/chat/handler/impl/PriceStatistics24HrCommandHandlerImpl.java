package com.application.chat.handler.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.TickerStatistics;
import com.application.chat.handler.CommandHandler;
import org.springframework.stereotype.Component;

/**
 * Обработчик команды "/priceStatistics24Hr".
 */
@Component
public class PriceStatistics24HrCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/priceStatistics24Hr".
     */
    private static final String COMMAND_STATISTICS_24HR = "/priceStatistics24Hr";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 2;

    /**
     * Индекс символа в массиве параметров команды.
     */
    public static final int PARAM_SYMBOL = 1;

    /**
     * Клиент для взаимодействия с Binance API.
     */
    private final BinanceApiRestClient binanceApiRestClient;

    /**
     * Создает новый экземпляр обработчика команды "/priceStatistics24Hr".
     *
     * @param binanceApiRestClient клиент для взаимодействия с Binance API
     */
    public PriceStatistics24HrCommandHandlerImpl(BinanceApiRestClient binanceApiRestClient) {
        this.binanceApiRestClient = binanceApiRestClient;
    }

    /**
     * Обрабатывает введенную команду "/priceStatistics24Hr".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /priceStatistics24Hr <SYMBOL>";
        }
        String symbol = params[PARAM_SYMBOL].toUpperCase();
        TickerStatistics tickerStatistics = binanceApiRestClient.get24HrPriceStatistics(symbol);
        if (tickerStatistics == null) {
            return "Не найдена статистика для данной валютной пары: " + symbol + ". " +
                    "Перейдите на биржу Binance для уточнения названия валютной пары.";
        }
        return tickerStatistics.toString();
    }

    /**
     * Возвращает имя команды "/priceStatistics24Hr".
     *
     * @return имя команды "/priceStatistics24Hr"
     */
    @Override
    public String getCommandName() {
        return COMMAND_STATISTICS_24HR;
    }
}
