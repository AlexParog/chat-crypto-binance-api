package com.application.chat.handler;

import com.application.chat.entity.Bot;
import com.application.chat.handler.impl.UnknownCommandHandlerImpl;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Класс CommandProcessor отвечает за обработку входящих сообщений и маршрутизацию их к соответствующим обработчикам команд
 * на основе извлеченного имени команды.
 *
 * @author alexanderbibik
 */
@Component
public class CommandProcessor {

    /**
     * Экземпляр бота.
     */
    private final Bot bot;

    /**
     * Словарь имен команд и соответствующих обработчиков.
     */
    private final Map<String, CommandHandler> commandHandlers;

    /**
     * Конструктор CommandProcessor с указанным ботом и картой обработчиков команд.
     *
     * @param bot             экземпляр бота
     * @param commandHandlers словарь имен команд и соответствующих им обработчиков
     */
    public CommandProcessor(Bot bot, Map<String, CommandHandler> commandHandlers) {
        this.bot = bot;
        this.commandHandlers = commandHandlers;
    }

    /**
     * Обрабатывает входящее сообщение и передает его соответствующему обработчику команды.
     *
     * @param message входящее сообщение
     * @return ответ, сгенерированный обработчиком команды
     */
    public String handleMessage(String message) {
        String commandName = extractCommandName(message);
        CommandHandler handler = commandHandlers.getOrDefault(commandName, new UnknownCommandHandlerImpl());
        return handler.handleCommand(message);
    }

    /**
     * Извлекает имя команды из заданного сообщения.
     *
     * @param message сообщение, из которого необходимо извлечь имя команды
     * @return извлеченное имя команды
     */
    private String extractCommandName(String message) {
        // Проверка на null и пустую строку
        if (message == null || message.isEmpty()) {
            return "";
        }

        // Извлечение имени команды
        int spaceIndex = message.indexOf(" ");
        String commandName;
        if (spaceIndex != -1) {
            // Если есть пробел, извлекаем часть строки до пробела
            commandName = message.substring(0, spaceIndex);
        } else {
            // Если нет пробела, вся строка является именем команды
            commandName = message;
        }

        return commandName;
    }
}
