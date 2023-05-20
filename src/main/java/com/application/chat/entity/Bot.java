package com.application.chat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Label;
import lombok.*;

import java.util.List;

/**
 * Доменная модель "Бота".
 *
 * @author alexanderbibik
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = Bot.TABLE_NAME)
@Label("Бот")
public class Bot extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "bots";

    /**
     * Класс констант, содержащих наименования колонок {@link Bot#TABLE_NAME}
     */
    static class ColumnName {
        public static final String BOT_CN_BOT_NAME = "bot_name";
    }

    /**
     * Имя бота.
     */
    @Label("Имя бота")
    @NonNull
    @NotBlank
    @Column(name = Bot.ColumnName.BOT_CN_BOT_NAME, nullable = false, length = 20)
    private String botName;

    /**
     * Команды чат-бота.
     */
    @Label("Команды чат-бота")
    @NonNull
    @OneToMany(mappedBy = Command.PropertyName.PN_BOT_COMMAND, fetch = FetchType.LAZY)
    private List<Command> botCommands;

    /**
     * Чаты, в которых состоит бот.
     */
    @Label("Чаты, в которых состоит бот")
    @OneToMany(mappedBy = Chat.PropertyName.PN_BOT_CHAT, fetch = FetchType.LAZY)
    private List<Chat> botChats;

    /**
     * Сообщения, принадлежащие боту.
     */
    @Label("Сообщения, принадлежащие боту")
    @OneToMany(mappedBy = Message.PropertyName.PN_BOT_MESSAGE, fetch = FetchType.LAZY)
    private List<Message> botMessages;
}
