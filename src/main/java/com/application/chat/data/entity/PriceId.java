package com.application.chat.data.entity;

import jakarta.persistence.Embeddable;
import jdk.jfr.Label;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Сущность для реализации состовного ключа Цены.
 * <p>
 * {@link Price}
 *
 * @author alexanderbibik
 */
@Embeddable
@Setter
@EqualsAndHashCode
@ToString
public class PriceId implements Serializable {

    /**
     * Идентификатор тикера.
     */
    @Label("Идентификатор тикера")
    private Long ticker;

    /**
     * Время последнего обноваления цены торговой пары.
     */
    @Label("Время последнего обноваления цены торговой пары")
    private LocalDateTime time;
}
