package com.application.chat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Label;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.List;

/**
 * Доменная модель "Пользователя".
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
@Table(name = User.TABLE_NAME)
@Label("Пользователь")
public class User extends AbstractEntity {

    /**
     * Наименование таблицы хранения.
     */
    public static final String TABLE_NAME = "users";

    /**
     * Класс констант, содержащих наименования колонок {@link User#TABLE_NAME}
     */
    static class ColumnName {
        public static final String USER_CN_FIRST_NAME = "first_name";
        public static final String USER_CN_LAST_NAME = "last_name";
        public static final String USER_CN_LOGIN = "login";
        public static final String USER_CN_ENCRYPTED_PASSWORD = "encrypted_password";
        public static final String USER_CN_EMAIL = "email";
        public static final String USER_CN_AVATAR = "avatar";
    }

    /**
     * Имя пользователя.
     */
    @Label("Имя пользователя")
    @Column(name = ColumnName.USER_CN_FIRST_NAME, nullable = false, length = 20)
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Label("Фамилия пользователя")
    @Column(name = ColumnName.USER_CN_LAST_NAME, nullable = false, length = 20)
    private String lastName;

    /**
     * Логин пользователя.
     */
    @Label("Логин пользователя")
    @NaturalId
    @NotBlank
    @NonNull
    @Column(name = ColumnName.USER_CN_LOGIN, length = 50, nullable = false, unique = true)
    private String login;

    /**
     * Зашифрованный пароль пользователя.
     */
    @Label("Зашифрованный пароль пользователя")
    @NotBlank
    @NonNull
    @JsonIgnore
    @Column(name = ColumnName.USER_CN_ENCRYPTED_PASSWORD, nullable = false, length = 60)
    private String encryptedPassword;

    /**
     * Адрес электронной почты пользователя.
     */
    @Label("Адрес электронной почты пользователя")
    @NaturalId
    @NotBlank
    @NonNull
    @Email
    @JsonIgnore
    @Column(name = ColumnName.USER_CN_EMAIL, length = 25, nullable = false, unique = true)
    private String email;

    /**
     * Аватар пользователя.
     */
    @Label("Аватар пользователя")
    @JsonIgnore
    @Column(name = ColumnName.USER_CN_AVATAR, length = 1000000)
    private String avatar;

    /**
     * Чаты, в которых состоит пользователь.
     */
    @Label("Чаты, в которых состоит пользователь")
    @NonNull
    @OneToMany(mappedBy = Chat.PropertyName.PN_USER_CHAT, fetch = FetchType.LAZY)
    private List<Chat> userChats;

    /**
     * Сообщения, принадлежащие пользователю.
     */
    @Label("Сообщения, принадлежащие пользователю")
    @OneToMany(mappedBy = Message.PropertyName.PN_USER_MESSAGE, fetch = FetchType.LAZY)
    private List<Message> userMessages;
}

