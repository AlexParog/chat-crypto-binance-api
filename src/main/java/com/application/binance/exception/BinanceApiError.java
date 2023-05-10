package com.application.binance.exception;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Объект ошибки Binance API.
 *
 * @author alexanderbibik
 */
@Getter
@Setter
public class BinanceApiError {

    /**
     * Код ошибки.
     */
    private int code;

    /**
     * Сообщение об ошибке.
     */
    private String msg;

    /**
     * Возвращает строковое представление объекта BinanceApiError.
     *
     * @return Строковое представление объекта BinanceApiError.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}
