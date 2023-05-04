package com.application.chat.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Label;
import lombok.*;

import java.util.List;

/**
 * Доменная модель "Чата".
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
@Table(name = Chat.TABLE_NAME)
@Label("Чат")
public class Chat extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "chats";

    /**
     * Класс констант, содержащих наименования колонок {@link Chat#TABLE_NAME}
     */
    static class ColumnName {
        public static final String CHAT_CN_CHAT_NAME = "chat_name";
        public static final String CHAT_CN_UNREAD_MESSAGES = "unread_messages";
        public static final String CHAT_CN_USER_ID = "user_id";
        public static final String CHAT_CN_BOT_ID = "bot_id";
    }

    /**
     * Класс констант, содержащих наименование свойств {@link Chat}, используемых в ссылках при объявлении доменной модели.
     */
    static class PropertyName {
        public static final String PN_USER_CHAT = "user";
        public static final String PN_BOT_CHAT = "bot";
    }

    /**
     * Название чата.
     */
    @Label("Название чата")
    @NotBlank
    @NonNull
    @Column(name = ColumnName.CHAT_CN_CHAT_NAME, nullable = false, length = 20, unique = true)
    private String chatName;

    /**
     * Количество непрочитанных сообщений пользователя.
     */
    @Label("Непрочитанные сообщения")
    @Column(name = ColumnName.CHAT_CN_UNREAD_MESSAGES, nullable = false, columnDefinition = "integer default 0")
    private int unreadMessages;

    /**
     * Пользователь, состоящий в данной чате.
     */
    @Label("Пользователь, состоящий в данной чате")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = ColumnName.CHAT_CN_USER_ID, nullable = false)
    private User user;

    /**
     * Бот, состоящий в данной чате.
     */
    @Label("Бот, состоящий в данной чате")
    @ManyToOne(optional = false)
    @NonNull
    @JoinColumn(name = ColumnName.CHAT_CN_BOT_ID, nullable = false)
    private Bot bot;

    /**
     * Сообщения принадлежащие конкретному чату.
     */
    @Label("Сообщения принадлежащие конкретному чату")
    @OneToMany(mappedBy = Message.PropertyName.PN_CHAT_MESSAGE, fetch = FetchType.LAZY)
    private List<Message> chatMessages;
}

