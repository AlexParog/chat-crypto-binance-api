package com.application.binance.domain.market;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Книга ордеров для символа на Binance.
 */
@Getter
@Setter
public class OrderBook {

    /**
     * Последний идентификатор обновления этой книги ордеров.
     */
    private long lastUpdateId;

    /**
     * Список ставок (цена/количество).
     */
    private List<OrderBookEntry> bids;

    /**
     * Список предложений (цена/количество).
     */
    private List<OrderBookEntry> asks;

    /**
     * Строка содержит информацию о последнем идентификаторе обновления книги ордеров,
     * списке ставок (цена/количество) и списке предложений (цена/количество).
     *
     * @return Строковое представление объекта класса {@link OrderBook}.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("lastUpdateId", lastUpdateId)
                .append("bids", bids)
                .append("asks", asks)
                .toString();
    }
}
