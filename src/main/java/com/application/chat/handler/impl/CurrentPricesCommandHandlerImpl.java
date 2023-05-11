package com.application.chat.handler.impl;

import com.application.binance.BinanceApiRestClient;
import com.application.binance.domain.market.TickerPrice;
import com.application.chat.handler.CommandHandler;
import org.springframework.stereotype.Component;

/**
 * Обработчик команды "/currentPrice".
 */
@Component
public class CurrentPricesCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/currentPrice".
     */
    private static final String COMMAND_CURRENT_PRICE = "/currentPrice";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 2;

    /**
     * Индекс параметра символа в команде.
     */
    public static final int PARAM_SYMBOL = 1;

    /**
     * REST-клиент для работы с API Binance.
     */
    private final BinanceApiRestClient binanceApiRestClient;

    /**
     * Конструктор класса.
     *
     * @param binanceApiRestClient REST-клиент для работы с API Binance
     */
    public CurrentPricesCommandHandlerImpl(BinanceApiRestClient binanceApiRestClient) {
        this.binanceApiRestClient = binanceApiRestClient;
    }

    /**
     * Обрабатывает введенную команду "/currentPrice".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /currentPrice <SYMBOL>";
        }
        String symbol = params[PARAM_SYMBOL].toUpperCase();
        TickerPrice tickerPrice = binanceApiRestClient.getTickerPrice(symbol);
        if (tickerPrice == null) {
            return "Не найдена статистика для данной валютной пары: " + symbol + ". " +
                    "Перейдите на биржу Binance для уточнения названия тикера.";
        }
        return tickerPrice.getPrice();
    }

    /**
     * Возвращает имя команды "/currentPrice".
     *
     * @return имя команды "/currentPrice"
     */
    @Override
    public String getCommandName() {
        return COMMAND_CURRENT_PRICE;
    }
}
