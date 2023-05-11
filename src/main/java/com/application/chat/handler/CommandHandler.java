package com.application.chat.handler;

/**
 * Базовый интерфейс, обрабатывающий команды чат-бота и возвращающий результат.
 */
public interface CommandHandler {

    /**
     * Обрабатывает команду и возвращает результат.
     *
     * @param command команда
     * @return строковый результат выполнения команды {@link com.application.chat.entity.BotCommandsEnum}.
     */
    String handleCommand(String command);

    /**
     *  Возвращает строкое название команды.
     *
     * @return строковое название.
     */
    String getCommandName();
}
