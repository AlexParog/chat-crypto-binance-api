-- Индексы для сущности "Пользователь"
create index users_login_idx on users (login);
create index users_email_idx on users (email);

-- Индексы для сущности "Чат"
create index chats_chat_name_idx on chats (chat_name);

-- Индексы для сущности "Бот"
create index bots_bot_name_idx on bots (bot_name);

-- Индексы для сущности "Команда"
create index commands_command_name_idx on commands (command_name);

