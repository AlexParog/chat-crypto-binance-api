package com.application.chat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Label;
import lombok.*;

/**
 * Доменная модель "Сообщения".
 *
 * @author alexanderbibik
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Message.TABLE_NAME)
@Label("Сообщение")
public class Message extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "messages";

    /**
     * Класс констант, содержащих наименования колонок {@link Message#TABLE_NAME}
     */
    static class ColumnName {
        public static final String MESSAGE_CN_TEXT_MESSAGE = "text_message";
        public static final String MESSAGE_CN_COMMAND_ID = "command_id";
        public static final String MESSAGE_CN_BOT_ID = "bot_id";
        public static final String MESSAGE_CN_USER_ID = "user_id";
        public static final String MESSAGE_CN_CHAT_ID = "chat_id";
    }

    /**
     * Класс констант, содержащих наименование свойств {@link Message}, используемых в ссылках при объявлении доменной модели.
     */
    static class PropertyName {
        public static final String PN_COMMAND_MESSAGE = "command";
        public static final String PN_BOT_MESSAGE = "bot";
        public static final String PN_USER_MESSAGE = "user";
        public static final String PN_CHAT_MESSAGE = "chat";
    }

    /**
     * Текс сообщения.
     */
    @Label("Текс сообщения")
    @NotBlank
    @NonNull
    @Column(name = Message.ColumnName.MESSAGE_CN_TEXT_MESSAGE, nullable = false, length = 600)
    private String textMessage;

    /**
     * Сообщение в виде команды.
     */
    @Label("Сообщение в виде команды")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = Message.ColumnName.MESSAGE_CN_COMMAND_ID, nullable = false)
    private Command command;

    /**
     * Бот, отправивший сообщения.
     */
    @Label("Бот, отправивший сообщения")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = Message.ColumnName.MESSAGE_CN_BOT_ID, nullable = false)
    private Bot bot;

    /**
     * Пользователь, отправивший сообщения.
     */
    @Label("Пользователь, отправивший сообщения")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = ColumnName.MESSAGE_CN_USER_ID, nullable = false)
    private User user;

    /**
     * Чат, содержащий сообщения.
     */
    @Label("Чат, содержащий сообщения")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = ColumnName.MESSAGE_CN_CHAT_ID, nullable = false)
    private Chat chat;
}
