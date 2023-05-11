package com.application.chat.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Label;
import lombok.*;

import java.util.List;

/**
 * Доменная модель "Команды".
 *
 * @author alexanderbibik
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = Command.TABLE_NAME)
@Label("Команда")
public class Command extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "commands";

    /**
     * Класс констант, содержащих наименования колонок {@link Command#TABLE_NAME}
     */
    static class ColumnName {
        public static final String COMMAND_CN_COMMAND_NAME = "command_name";
        public static final String COMMAND_CN_DESCRIPTION = "description";
        public static final String COMMAND_CN_BOT_ID = "bot_id";
    }

    /**
     * Класс констант, содержащих наименование свойств {@link Command}, используемых в ссылках при объявлении доменной модели.
     */
    static class PropertyName {
        public static final String PN_BOT_COMMAND = "bot";
    }

    /**
     * Название команды.
     */
    @Label("Название команды")
    @NonNull
    @NotBlank
    @Column(name = Command.ColumnName.COMMAND_CN_COMMAND_NAME, nullable = false, length = 40, unique = true)
    private String commandName;

    /**
     * Описание команды.
     */
    @Label("Описание команды")
    @NonNull
    @NotBlank
    @Column(name = Command.ColumnName.COMMAND_CN_DESCRIPTION, nullable = false, length = 300)
    private String description;

    /**
     * Команда.
     */
    @Label("Команда")
    @Enumerated(EnumType.STRING)
    @NonNull
    private BotCommandsEnum botCommand;

    /**
     * Бот, имеющий данные команды.
     */
    @Label("Бот, имеющий данные команды")
    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = Command.ColumnName.COMMAND_CN_BOT_ID, nullable = false)
    private Bot bot;

    /**
     * Список сообщений в виде команд.
     */
    @Label("Список сообщений в виде команд")
    @OneToMany(mappedBy = Message.PropertyName.PN_COMMAND_MESSAGE, fetch = FetchType.LAZY)
    private List<Message> commandMessages;

}
