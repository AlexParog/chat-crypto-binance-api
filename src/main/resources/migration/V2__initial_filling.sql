-- Дефолтное наполнение пользователя
insert into users (id, first_name, last_name, login, email, encrypted_password, created_at, last_modified_at)
values (1, 'Александр', 'Парог', 'alexparog', 'abibik@gmail.com', 'qwerty', '2023-05-04 18:20', null);

-- Дефолтное наполнение бота
insert into bots (id, bot_name, created_at, last_modified_at)
values (1, 'Crypto-bot', '2023-05-04 18:20', null);

-- Дефотлное наполенение чата
insert into chats (user_id, bot_id, chat_name, unread_messages, created_at, last_modified_at)
values (1, 1, 'MainChat', 0, '2023-05-04 18:20', null);

insert into commands(id, bot_id, command_name, description, bot_command, created_at, last_modified_at)
VALUES (1, 1, '/start', 'Команда знакомства пользователя с ботом.', 'START', '2023-05-04 18:20', null),
       (2, 1, '/currentPrice', 'Команда чат-бота, позволяющая узнать текущую цену конкретной криптовалюты.',
        'CURRENT_PRICES', '2023-05-04 18:20', null),
       (3, 1, '/priceStatistics24Hr',
        'Команда чат-бота, позволяющая узнать статистику торгов за последние 24 часа.',
        'PRICE_STATISTICS_24HR', '2023-05-04 18:20', null),
       (4, 1, '/help', 'Команда чат-бота, позволяющая напомнить пользователю какие существуют команды с их описанием.',
        'HELP', '2023-05-04 18:20', null),
       (5, 1, '/openPrice',
        'Команд, позволяющая определять цену открытия свечного периода для пары торгов за определенный промежуток времени.',
        'OPEN_PRICE', '2023-05-04 18:20', null),
       (6, 1, '/closePrice',
        'Команд, позволяющая определять цену закрытия свечного периода для пары торгов за определенный промежуток времени.',
        'CLOSE_PRICE', '2023-05-04 18:20', null),
       (7, 1, '/openingTime', 'Команд, позволяющая определять время открытия свечного периода для пары торгов.',
        'OPENING_TIME', '2023-05-04 18:20', null),
       (8, 1, '/closingTime', 'Команд, позволяющая определять время закрытия свечного периода для пары торгов.',
        'CLOSING_TIME', '2023-05-04 18:20', null),
       (9, 1, '/unknown_command', 'Неизвестная команда.', 'UNKNOWN_COMMAND', '2023-05-04 18:20', null);