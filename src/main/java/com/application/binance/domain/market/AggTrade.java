package com.application.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Событие агрегированной сделки для символа.
 *
 * @author alexanderbibik
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class AggTrade {

    /**
     * Идентификатор агрегированной сделки.
     */
    @JsonProperty("a")
    private long aggregatedTradeId;

    /**
     * Цена сделки.
     */
    @JsonProperty("p")
    private String price;

    /**
     * Количество сделки.
     */
    @JsonProperty("q")
    private String quantity;

    /**
     * Идентификатор первой сделки.
     */
    @JsonProperty("f")
    private long firstBreakdownTradeId;

    /**
     * Идентификатор последней сделки.
     */
    @JsonProperty("l")
    private long lastBreakdownTradeId;

    /**
     * Время совершения сделки.
     */
    @JsonProperty("T")
    private long tradeTime;

    /**
     * Флаг, указывающий, является ли покупатель инициатором сделки.
     */
    @JsonProperty("m")
    private boolean isBuyerMaker;

    /**
     * Возвращает строковое представление объекта AggTrade.
     *
     * @return Строковое представление объекта AggTrade.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("aggregatedTradeId", aggregatedTradeId)
                .append("price", price)
                .append("quantity", quantity)
                .append("firstBreakdownTradeId", firstBreakdownTradeId)
                .append("lastBreakdownTradeId", lastBreakdownTradeId)
                .append("tradeTime", tradeTime)
                .append("isBuyerMaker", isBuyerMaker)
                .toString();
    }
}

