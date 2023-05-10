package com.application.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Статистика изменения цены за 24 часа для тикера.
 *
 * @author alexanderbibik
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class TickerStatistics {

    /**
     * Изменение цены за последние 24 часа.
     */
    private String priceChange;

    /**
     * Изменение цены в процентах за последние 24 часа.
     */
    private String priceChangePercent;

    /**
     * Взвешенная средняя цена.
     */
    private String weightedAvgPrice;

    /**
     * Предыдущая цена закрытия.
     */
    private String prevClosePrice;

    /**
     * Последняя цена.
     */
    private String lastPrice;

    /**
     * Цена предложения (bid).
     */
    private String bidPrice;

    /**
     * Цена спроса (ask).
     */
    private String askPrice;

    /**
     * Цена открытия 24 часа назад.
     */
    private String openPrice;

    /**
     * Самая высокая цена за последние 24 часа.
     */
    private String highPrice;

    /**
     * Самая низкая цена за последние 24 часа.
     */
    private String lowPrice;

    /**
     * Общий объем за последние 24 часа.
     */
    private String volume;

    /**
     * Время открытия.
     */
    private long openTime;

    /**
     * Время закрытия.
     */
    private long closeTime;

    /**
     * Идентификатор первой сделки.
     */
    private long firstId;

    /**
     * Идентификатор последней сделки.
     */
    private long lastId;

    /**
     * Общее количество сделок за последние 24 часа.
     */
    private long count;

    /**
     * Возвращает строковое представление объекта TickerStatistics.
     *
     * @return Строковое представление объекта {@link TickerStatistics}.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("priceChange", priceChange)
                .append("priceChangePercent", priceChangePercent)
                .append("weightedAvgPrice", weightedAvgPrice)
                .append("prevClosePrice", prevClosePrice)
                .append("lastPrice", lastPrice)
                .append("bidPrice", bidPrice)
                .append("askPrice", askPrice)
                .append("openPrice", openPrice)
                .append("highPrice", highPrice)
                .append("lowPrice", lowPrice)
                .append("volume", volume)
                .append("openTime", openTime)
                .append("closeTime", closeTime)
                .append("firstId", firstId)
                .append("lastId", lastId)
                .append("count", count)
                .toString();
    }
}
