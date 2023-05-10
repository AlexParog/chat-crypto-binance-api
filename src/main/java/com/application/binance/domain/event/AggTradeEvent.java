package com.application.binance.domain.event;

import com.application.binance.domain.market.AggTrade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Событие агрегированной сделки для символа.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class AggTradeEvent extends AggTrade {

    /**
     * Тип события.
     */
    @JsonProperty("e")
    private String eventType;

    /**
     * Время события.
     */
    @JsonProperty("E")
    private long eventTime;

    /**
     * Символ.
     */
    @JsonProperty("s")
    private String symbol;

    /**
     * Возвращает строковое представление объекта AggTradeEvent.
     *
     * @return Строковое представление объекта AggTradeEvent.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("aggTrade", super.toString())
                .toString();
    }
}
