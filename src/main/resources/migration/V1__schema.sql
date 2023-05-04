-- Таблица "Пользователя"
create table users
(
    id                 bigserial primary key not null,
    first_name         varchar(20)           not null,
    last_name          varchar(20)           not null,
    login              varchar(50)           not null unique,
    encrypted_password varchar(60)           not null,
    email              varchar(25)           not null unique,
    avatar             varchar(1000000),
    created_at         timestamp,
    last_modified_at   timestamp
);

-- Таблица "Чата"
create table chats
(
    id               bigserial primary key not null,
    user_id          bigint                not null,
    bot_id           bigint                not null,
    chat_name        varchar(20)           not null unique,
    unread_messages  int                   not null default 0,
    created_at       timestamp,
    last_modified_at timestamp
);

-- Таблица "Бота"
create table bots
(
    id               bigserial primary key not null,
    bot_name         varchar(20)           not null,
    created_at       timestamp,
    last_modified_at timestamp
);

-- Таблица "Команды"
create table commands
(
    id               bigserial primary key not null,
    bot_id           bigint                not null,
    command_name     varchar(40)           not null unique,
    description      varchar(300)          not null,
    bot_command      varchar(40)           not null,
    created_at       timestamp,
    last_modified_at timestamp
);

-- Таблица "Сообщения"
create table messages
(
    id               bigserial primary key not null,
    command_id       bigint                not null,
    bot_id           bigint                not null,
    user_id          bigint                not null,
    chat_id          bigint                not null,
    text_message     varchar(600)          not null,
    created_at       timestamp,
    last_modified_at timestamp
);

-- Связь между сущностью "Пользователь" и "Чат"
alter table only chats
    add foreign key (user_id) references users (id);
-- Связь между сущностью "Бот" и "Чат"
alter table only chats
    add foreign key (bot_id) references bots (id);
-- Связь между сущностью "Бот" и "Команда"
alter table only commands
    add foreign key (bot_id) references bots (id);
-- Связь между сущностью "Команда" и "Сообщение"
alter table only messages
    add foreign key (command_id) references commands (id);
-- Связь между сущностью "Бот" и "Сообщение"
alter table only messages
    add foreign key (bot_id) references bots (id);
-- Связь между сущностью "Пользователь" и "Сообщение"
alter table only messages
    add foreign key (user_id) references users (id);
-- Связь между сущностью "Чат" и "Сообщение"
alter table only messages
    add foreign key (chat_id) references chats (id);


