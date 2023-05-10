package com.application.binance.domain.market;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Запись книги ордеров, состоящая из цены и количества.
 *
 * @author alexanderbibik
 */
@JsonDeserialize(using = OrderBookEntryDeserializer.class)
@Getter
@Setter
public class OrderBookEntry {

    /**
     * Цена ордера.
     */
    private String price;

    /**
     * Количество ордера.
     */
    private String qty;

    /**
     * Строка содержит информацию о цене и количестве ордера.
     *
     * @return Строковое представление объекта класса {@link OrderBookEntry}.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("price", price)
                .append("qty", qty)
                .toString();
    }
}
