package com.application.chat.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Label;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "users";

    static class ColumnName {
        public static final String USER_CN_ID = "id";
        public static final String USER_CN_FIRST_NAME = "first_name";
        public static final String USER_CN_LAST_NAME = "last_name";
        public static final String USER_CN_LOGIN = "login";
        public static final String USER_CN_ENCRYPTED_PASSWORD = "encrypted_password";
        public static final String USER_CN_EMAIL = "email";
        public static final String USER_CN_AVATAR = "avatar";

    }

    @Label("Идентификатор пользователя")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnName.USER_CN_ID)
    private String id;

    @Label("Имя пользователя")
    @NotNull
    @Column(name = ColumnName.USER_CN_FIRST_NAME, nullable = false, length = 20)
    private String firstName;

    @Label("Фамилия пользователя")
    @NotNull
    @Column(name = ColumnName.USER_CN_LAST_NAME, nullable = false, length = 20)
    private String lastName;

    @Label("Логин пользователя")
    @NotNull
    @Column(name = ColumnName.USER_CN_LOGIN, length = 50, nullable = false, unique = true)
    private String login;

    @Label("Зашифрованный пароль пользователя")
    @NotNull
    @Column(name = ColumnName.USER_CN_ENCRYPTED_PASSWORD, nullable = false, length = 60)
    private String encryptedPassword;

    @Label("Адрес электронной почты пользователя")
    @NotNull
    @Email
    @Column(name = ColumnName.USER_CN_EMAIL, length = 25, nullable = false, unique = true)
    private String email;

    @Label("Аватар пользователя")
    @Column(name = ColumnName.USER_CN_AVATAR, length = 1000000)
    private String avatar;

    @Label("Чаты пользователя")
    @OneToMany(mappedBy = Chat.PropertyName.PN_USER_CHAT, fetch = FetchType.LAZY)
    private List<Chat> userChats;
}

