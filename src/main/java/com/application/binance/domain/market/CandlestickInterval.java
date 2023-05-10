package com.application.binance.domain.market;

/**
 * Интервалы Kline/Candlestick.
 * m -> минуты; h -> часы; d -> дни; w -> недели; M -> месяцы
 *
 * @author alexanderbibik
 */
public enum CandlestickInterval {
    /**
     * 1 минута.
     */
    ONE_MINUTE("1m"),

    /**
     * 3 минуты.
     */
    THREE_MINUTES("3m"),

    /**
     * 5 минут.
     */
    FIVE_MINUTES("5m"),

    /**
     * 15 минут.
     */
    FIFTEEN_MINUTES("15m"),

    /**
     * 30 минут.
     */
    HALF_HOURLY("30m"),

    /**
     * 1 час.
     */
    HOURLY("1h"),

    /**
     * 2 часа.
     */
    TWO_HOURLY("2h"),

    /**
     * 4 часа.
     */
    FOUR_HORLY("4h"),

    /**
     * 6 часов.
     */
    SIX_HOURLY("6h"),

    /**
     * 8 часов.
     */
    EIGHT_HOURLY("8h"),

    /**
     * 12 часов.
     */
    TWELVE_HOURLY("12h"),

    /**
     * 1 день.
     */
    DAILY("1d"),

    /**
     * 3 дня.
     */
    THREE_DAILY("3d"),

    /**
     * 1 неделя.
     */
    WEEKLY("1w"),

    /**
     * 1 месяц.
     */
    MONTHLY("1M");

    /**
     * Идентификатор интервала.
     */
    private final String intervalId;

    /**
     * Конструктор класса CandlestickInterval.
     *
     * @param intervalId Идентификатор интервала.
     */
    CandlestickInterval(String intervalId) {
        this.intervalId = intervalId;
    }

    /**
     * Возвращает идентификатор интервала.
     *
     * @return Идентификатор интервала.
     */
    public String getIntervalId() {
        return intervalId;
    }
}
