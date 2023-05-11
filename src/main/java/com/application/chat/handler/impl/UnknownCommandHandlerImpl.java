package com.application.chat.handler.impl;

import com.application.chat.handler.CommandHandler;

/**
 * Обработчик неизвестной команды.
 *
 * @author alexanderbibik
 */
public class UnknownCommandHandlerImpl implements CommandHandler {
    /**
     * Строковое обозначение для неизвестной команды.
     */
    private static final String COMMAND_UNKNOWN = "/unknowncommand";

    /**
     * Обрабатывает введенную команду.
     *
     * @param command введенная команда
     * @return текст сообщения об ошибке неизвестной команды
     */
    @Override
    public String handleCommand(String command) {
        return "Неизвестная команда: " + command + ". Воспользуйтесь командой '/start', если вы не начинали работу с ботом." +
                "Если же не помните команд КРИПТОнита, то воспользутесь командой '/help'";
    }

    /**
     * Возвращает имя команды для неизвестной команды.
     *
     * @return имя команды для неизвестной команды
     */
    @Override
    public String getCommandName() {
        return COMMAND_UNKNOWN;
    }
}
