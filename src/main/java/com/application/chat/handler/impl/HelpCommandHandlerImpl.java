package com.application.chat.handler.impl;

import com.application.chat.handler.CommandHandler;

/**
 * Обработчик команды "/help".
 */
public class HelpCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/help".
     */
    private static final String COMMAND_HELP = "/help";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 1;

    /**
     * Сообщение с инструкцией по использованию команд.
     */
    private static final String RESULT_HELP_MESSAGE =
            """
                    Я все тот же бот КРИПТОнит. Я умею:\s
                    * узнавать текущую цену криптовалютной пары - команда '/currentPrice <SYMBOL>';
                    * узнавать статистику торгов за послдение 24 часа - команда '/priceStatistics24Hr <SYMBOL>';
                    * узнавать цену открытия свечного периода для пары торгов за определенный промежуток времени - команда '/openPrice <SYMBOL> <TIME>';
                    * определять цену закрытия свечного периода для пары торгов за определенный промежуток времени - команда '/closePrice <SYMBOL> <TIME>';
                    * определять время открытия свечного периода для пары торгов - команда '/openingTime <SYMBOL> <TIME>';
                    * определять время закрытия свечного периода для пары торгов - команда '/closingTime <SYMBOL> <TIME>';
                    P.S: для команд, где используется параметр <TIME> есть формат времени:
                    * час -> HOURLY
                    * 8 часов -> EIGHT_HOURLY
                    * 12 часов -> TWELVE_HOURLY
                    * день -> DAILY
                    * 3 дня -> THREE_DAILY
                    * неделя -> WEEKLY
                    * месяц -> MONTHLY""";

    /**
     * Обрабатывает введенную команду "/help".
     *
     * @param command введенная команда
     * @return результат обработки команды
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /help";
        }
        return RESULT_HELP_MESSAGE;
    }

    /**
     * Возвращает имя команды "/help".
     *
     * @return имя команды "/help"
     */
    @Override
    public String getCommandName() {
        return COMMAND_HELP;
    }
}
