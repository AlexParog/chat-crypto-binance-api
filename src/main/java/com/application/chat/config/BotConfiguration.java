package com.application.chat.config;

import com.application.binance.BinanceApiRestClient;
import com.application.chat.entity.Bot;
import com.application.chat.entity.BotCommandsEnum;
import com.application.chat.entity.Command;
import com.application.chat.handler.CommandHandler;
import com.application.chat.handler.CommandProcessor;
import com.application.chat.handler.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BotConfiguration является конфигурационным классом для настройки и создания экземпляров
 * бота и обработчиков команд.
 *
 * @author alexanderbibik
 */
@Configuration
public class BotConfiguration {

    /**
     * Фасад Binance API, поддерживающий доступ к REST API Binance.
     */
    @Autowired
    private BinanceApiRestClient binanceApiRestClient;

    /**
     * Создает и настраивает экземпляр бота.
     *
     * @return экземпляр бота
     */
    @Bean
    public Bot bot() {
        Bot bot = new Bot();
        bot.setBotName("КРИПТОнит");

        List<Command> commands = List.of(
                new Command("/start",
                        "Команда знакомства пользователя с ботом.",
                        BotCommandsEnum.START, bot),
                new Command("/currentPrice",
                        "Команда чат-бота, позволяющая узнать текущую цену конкретной криптовалюты.",
                        BotCommandsEnum.CURRENT_PRICES, bot),
                new Command("/priceStatistics24Hr",
                        "Команда чат-бота, позволяющая узнать статистику торгов за последние 24 часа.",
                        BotCommandsEnum.PRICE_STATISTICS_24HR, bot),
                new Command("/help",
                        "Команда чат-бота, позволяющая напомнить пользователю какие существуют команды с их описанием.",
                        BotCommandsEnum.HELP, bot),
                new Command("/openPrice",
                        "Команд, позволяющая определять цену открытия свечного периода для пары торгов за определенный промежуток времени.",
                        BotCommandsEnum.OPEN_PRICE, bot),
                new Command("/closePrice",
                        "Команд, позволяющая определять цену закрытия свечного периода для пары торгов за определенный промежуток времени.",
                        BotCommandsEnum.CLOSE_PRICE, bot),
                new Command("/openingTime",
                        "Команд, позволяющая определять время открытия свечного периода для пары торгов.",
                        BotCommandsEnum.OPENING_TIME, bot),
                new Command("/closingTime",
                        "Команд, позволяющая определять время закрытия свечного периода для пары торгов.",
                        BotCommandsEnum.CLOSING_TIME, bot),
                new Command("/unknown_command",
                        "Неизвестная команда.",
                        BotCommandsEnum.UNKNOWN_COMMAND, bot)
        );

        bot.setBotCommands(commands);

        return bot;
    }

    /**
     * Создает и настраивает обработчик команды /start.
     *
     * @return обработчик команды /start
     */
    @Bean
    public CommandHandler startCommandHandler() {
        return new StartCommandHandlerImpl();
    }

    /**
     * Создает и настраивает обработчик команды /priceStatistics24Hr.
     *
     * @return обработчик команды /priceStatistics24Hr
     */
    @Bean
    public CommandHandler priceStatistics24HrCommandHandler() {
        return new PriceStatistics24HrCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик команды /openPrice.
     *
     * @return обработчик команды /openPrice
     */
    @Bean
    public CommandHandler OpenPriceCommandHandler() {
        return new OpenPriceCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик команды /openingTime.
     *
     * @return обработчик команды /openingTime
     */
    @Bean
    public CommandHandler OpeningTimeCommandHandler() {
        return new OpeningTimeCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик команды /help.
     *
     * @return обработчик команды /help
     */
    @Bean
    public CommandHandler HelpCommandHandler() {
        return new HelpCommandHandlerImpl();
    }

    /**
     * Создает и настраивает обработчик команды /currentPrice.
     *
     * @return обработчик команды /currentPrice
     */
    @Bean
    public CommandHandler CurrentPricesCommandHandler() {
        return new CurrentPricesCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик команды /closingTime.
     *
     * @return обработчик команды /closingTime
     */
    @Bean
    public CommandHandler ClosingTimeCommandHandler() {
        return new ClosingTimeCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик команды /closePrice.
     *
     * @return обработчик команды /closePrice
     */
    @Bean
    public CommandHandler ClosePriceCommandHandler() {
        return new ClosePriceCommandHandlerImpl(binanceApiRestClient);
    }

    /**
     * Создает и настраивает обработчик неизвестной команды.
     *
     * @return обработчик неизвестной команды
     */
    @Bean
    public CommandHandler UnknownCommandHandler() {
        return new UnknownCommandHandlerImpl();
    }

    /**
     * Создает и настраивает процессор команд с заданным ботом и картой обработчиков команд.
     *
     * @param bot экземпляр бота
     * @return экземпляр процессора команд
     */
    @Bean
    public CommandProcessor commandProcessor(Bot bot, List<CommandHandler> commandHandlers) {
        Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
        for (CommandHandler handler : commandHandlers) {
            commandHandlerMap.put(handler.getCommandName(), handler);
        }
        return new CommandProcessor(bot, commandHandlerMap);
    }

}
