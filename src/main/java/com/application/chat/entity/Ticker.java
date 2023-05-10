package com.application.chat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Доменная модель "Тикера".
 *
 * @author alexanderbibik
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Ticker.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "name_unique", columnNames = "name")
})
public class Ticker extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "tickers";

    /**
     * Класс констант, содержащих наименования колонок {@link Ticker#TABLE_NAME}
     */
    static class ColumnName {
        public static final String TICKER_CN_NAME = "name";
    }

    @Label("Название торговой пары")
    @Column(name = ColumnName.TICKER_CN_NAME)
    private String name;

    @Label("Значение цен торговой пары")
    @OneToMany(mappedBy = Price.PropertyName.PN_TICKER_PRICE, fetch = FetchType.LAZY)
    private List<Price> prices;

    @Label("Дата создания сущности")
    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdAt;

    @Label("Дата последней модификации сущности")
    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime lastModifiedAt;
}
