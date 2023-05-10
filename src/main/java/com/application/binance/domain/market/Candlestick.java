package com.application.binance.domain.market;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Пары Kline/Candlestick для символа. Kline уникально идентифицируются по времени их открытия.
 *
 * @author alexanderbibik
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Candlestick {

    /**
     * Время открытия.
     */
    private Long openTime;

    /**
     * Цена открытия.
     */
    private String open;

    /**
     * Максимальная цена.
     */
    private String high;

    /**
     * Минимальная цена.
     */
    private String low;

    /**
     * Цена закрытия.
     */
    private String close;

    /**
     * Объем.
     */
    private String volume;

    /**
     * Время закрытия.
     */
    private Long closeTime;

    /**
     * Объем в котируемой валюте.
     */
    private String quoteAssetVolume;

    /**
     * Количество сделок.
     */
    private Long numberOfTrades;

    /**
     * Объем базовой валюты продавца.
     */
    private String takerBuyBaseAssetVolume;

    /**
     * Объем котируемой валюты продавца.
     */
    private String takerBuyQuoteAssetVolume;

    /**
     * Возвращает строковое представление объекта Candlestick.
     *
     * @return Строковое представление объекта Candlestick.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("openTime", openTime)
                .append("open", open)
                .append("high", high)
                .append("low", low)
                .append("close", close)
                .append("volume", volume)
                .append("closeTime", closeTime)
                .append("quoteAssetVolume", quoteAssetVolume)
                .append("numberOfTrades", numberOfTrades)
                .append("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                .append("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume)
                .toString();
    }
}
