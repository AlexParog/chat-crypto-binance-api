package com.application.chat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Label;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
    @Label("Идентификатор сущности")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Label("Дата создания сущности")
    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdAt;

    @Label("Дата последней модификации сущности")
    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime lastModifiedAt;

    //TODO нужно ли добавлять поле archive для метки удаления?
}
