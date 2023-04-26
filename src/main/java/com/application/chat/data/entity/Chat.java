package com.application.chat.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Chat.TABLE_NAME)
public class Chat {

    public static final String TABLE_NAME = "chats";

    static class ColumnName {
        public static final String CHAT_CN_ID = "id";
        public static final String CHAT_CN_CHAT_NAME = "chat_name";
        public static final String CHAT_CN_UNREAD_MESSAGES = "unread_messages";
        public static final String CHAT_CN_CHAT_CREATION_DATE = "chat_creation_date";
        public static final String CHAT_CN_USER_ID = "user_id";
    }

    static class PropertyName {
        public static final String PN_USER_CHAT = "user";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnName.CHAT_CN_ID)
    private String id;

    @NotNull
    @Column(name = ColumnName.CHAT_CN_CHAT_NAME, nullable = false, length = 20)
    private String chatName;

    @NotNull
    @Column(name = ColumnName.CHAT_CN_UNREAD_MESSAGES, nullable = false, columnDefinition = "integer default 0")
    private int unreadMessages;

    @NotNull
    @Column(name = ColumnName.CHAT_CN_CHAT_CREATION_DATE, nullable = false)
    @CreatedDate
    private LocalDateTime chatCreationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = ColumnName.CHAT_CN_USER_ID, nullable = false)
    private User user;

}

