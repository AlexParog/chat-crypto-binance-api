package com.application.chat.handler.impl;

import com.application.chat.handler.CommandHandler;
import org.springframework.stereotype.Component;

/**
 * Обработчик команды "/start".
 *
 * @author alexanderbibik
 */
@Component
public class StartCommandHandlerImpl implements CommandHandler {

    /**
     * Команда "/start".
     */
    private static final String COMMAND_START = "/start";

    /**
     * Количество параметров команды.
     */
    public static final int PARAMS_LENGTH = 1;

    /**
     * Сообщение, выводимое при выполнении команды "/start".
     */
    private static final String RESULT_START_MESSAGE =
            """
                    Добро пожаловать! Я бот КРИПТОнит. Я умею:\s
                    * узнавать текущую цену криптовалютной пары;
                    * узнавать статистику торгов за послдение 24 часа;
                    * узнавать цену открытия свечного периода для пары торгов за определенный промежуток времени (час, 8 часов, 12 часов, день, 3 дня, неделя, месяц);
                    * определять цену закрытия свечного периода для пары торгов за определенный промежуток времени (час, 8 часов, 12 часов, день, 3 дня, неделя, месяц);
                    * определять время открытия свечного периода для пары торгов;
                    * определять время закрытия свечного периода для пары торгов.
                    Чтобы посмотреть, как ввести команды воспользуйся команду '/help'!""";

    /**
     * Обрабатывает введенную команду "/start".
     *
     * @param command введенная команда
     * @return сообщение, выводимое при выполнении команды "/start"
     */
    @Override
    public String handleCommand(String command) {
        String[] params = command.split(" ");
        if (params.length > PARAMS_LENGTH) {
            return "Неправильный формат команды. Воспользуйтесь: /start";
        }
        return RESULT_START_MESSAGE;
    }

    /**
     * Возвращает имя команды "/start".
     *
     * @return имя команды "/start"
     */
    @Override
    public String getCommandName() {
        return COMMAND_START;
    }
}
