package com.application.chat.entity;

/**
 * Перечень доступных команд чата-бота.
 *
 * @author alexanderbibik
 */
public enum BotCommandsEnum {
    /**
     * Команда знакомства пользователя с ботом.
     */
    START("/start"),

    /**
     * Команда чат-бота, позволяющая узнать текущую цену конкретной криптовалюты.
     */
    CURRENT_PRICES("/currentPrice"),

    /**
     * Команда чат-бота, позволяющая узнать статистику торгов за последние 24 часа.
     */
    PRICE_STATISTICS_24HR("/priceStatistics24Hr"),

    /**
     * Команда чат-бота, позволяющая напомнить пользователю какие существуют команды с их описанием.
     */
    HELP("/help"),

    /**
     * Команд, позволяющая определять цену открытия свечного периода для пары торгов за определенный промежуток времени.
     */
    OPEN_PRICE("/openPrice"),

    /**
     * Команд, позволяющая определять цену закрытия свечного периода для пары торгов за определенный промежуток времени.
     */
    CLOSE_PRICE("/closePrice"),

    /**
     * Команд, позволяющая определять время открытия свечного периода для пары торгов.
     */
    OPENING_TIME("/openingTime"),

    /**
     * Команд, позволяющая определять время закрытия свечного периода для пары торгов.
     */
    CLOSING_TIME("/closingTime");

    /**
     * Значение команды.
     */
    private final String command;

    BotCommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
