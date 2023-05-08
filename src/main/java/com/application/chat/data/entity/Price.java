package com.application.chat.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Доменная модель "Цены".
 *
 * @author alexanderbibik
 */
@Entity
@Getter
@Setter
@IdClass(PriceId.class)
@NoArgsConstructor
@Table(name = Price.TABLE_NAME)
public class Price {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "prices";

    /**
     * Класс констант, содержащих наименования колонок {@link Price#TABLE_NAME}
     */
    static class ColumnName {
        public static final String PRICE_CN_TICKER_ID = "ticker_id";
        public static final String PRICE_RCN_ID = "id";
        public static final String PRICE_CN_TICKER_FK = "ticker_fk";
        public static final String PRICE_CN_TIME = "time";
        public static final String PRICE_CN_VALUE = "value";
    }

    /**
     * Класс констант, содержащих наименование свойств {@link Price}, используемых в ссылках при объявлении доменной модели.
     */
    static class PropertyName {
        public static final String PN_TICKER_PRICE = "ticker";
    }

    /**
     * Название торговой пары.
     */
    @Label("Название торговой пары")
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = ColumnName.PRICE_CN_TICKER_ID,
            referencedColumnName = ColumnName.PRICE_RCN_ID,
            foreignKey = @ForeignKey(name = ColumnName.PRICE_CN_TICKER_FK))
    private Ticker ticker;

    /**
     * Время последнего обноваления цены торговой пары.
     */
    @Label("Время последнего обноваления цены торговой пары")
    @Id
    @Column(name = ColumnName.PRICE_CN_TIME)
    private LocalDateTime time;

    /**
     * Значение цены.
     */
    @Label("Значение цены")
    @Column(name = ColumnName.PRICE_CN_VALUE, precision = 10, scale = 7)
    private BigDecimal value;

    /**
     * Дата создания сущности.
     */
    @Label("Дата создания сущности")
    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdAt;

    /**
     * Дата последней модификации сущности.
     */
    @Label("Дата последней модификации сущности")
    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime lastModifiedAt;
}
