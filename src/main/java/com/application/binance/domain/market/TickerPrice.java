package com.application.binance.domain.market;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Обёртка для символа и соответствующей ему последней цены.
 *
 * @author alexanderbibik
 */
@Getter
@Setter
public class TickerPrice {

    /**
     * Символ.
     */
    private String symbol;

    /**
     * Последняя цена.
     */
    private String price;

    /**
     * Возвращает строковое представление объекта TickerPrice.
     *
     * @return Строковое представление объекта {@link TickerPrice}.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("symbol", symbol)
                .append("price", price)
                .toString();
    }
}
