Разработка информационной системы по автоматизированному поиску криптовалюты на основе чат-бота
================================


## Технологии: 
- Java 17
- Spring Boot 3
- Vaadin 24
- PostgreSQL
- Flyway
- Lombok
- Retrofit
- Binance API


## Использованные сущности Binance API:
- `Order Book`
- `Aggregate Trades List`
- `Candlestick Data`
- `24hr Ticker Price Change Statistics`
- `Symbol Price Ticker`

## Функциональные требования
1.	Управление чатами:
      - Пользователь может иметь чат с ботом.
      - После успешного входа в систему пользователь увидит чат, в которых он может общаться с ботом.
2.	Получение данных из Binance API:
      - Система будет использовать Binance API для получения данных о криптовалютах и торговой статистике.
      - Запросы к Binance API будут осуществляться для получения актуальной информации о ценах и статистике торгов.
3.	Основное окно чата:
      - Пользователь будет видеть основное окно чата, где он может отправлять сообщения и получать ответы от бота.
      - Команды, начинающиеся со знака `/`, будут использоваться для взаимодействия с чат-ботом.

## Доступные команды бота:
- `/start`: команда, знакомившая пользователя с чат-ботом, а также описывает пользователю функционал чат-бота.
- `/currentPrice <SYMBOL>`: команда позволяет узнать текущую цену указанной криптовалютной торговой пары.
- `/priceStatistics24Hr <SYMBOL>`: команда позволяет получить статистику торгов за последние 24 часа для указанной криптовалютой торговой пары.
- `/help`: команда позволяет получить список доступных команд с их описанием.
- `/openPrice <TIME> <SYMBOL>`: команда позволяет определить цену открытия свечного периода для указанной криптовалютной торговой пары и временного интервала.
- `/closePrice <TIME> <SYMBOL>`: Команда позволяет определить цену закрытия свечного периода для указанной криптовалютной торговой пары и временного интервала.
- `/openingTime <SYMBOL> <TIME>`: Команда позволяет определить время открытия свечного периода для указанной криптовалютной торговой пары и временного интервала.
- `/closingTime <SYMBOL> <TIME>`: Команда позволяет определить время закрытия свечного периода для указанной криптовалютной торговой пары и временного интервала.
- В случае непонятного ввода от пользователя чат-бот выведет информацию о нераспознанной команде и напомнит пользователю о команде `/help`, где подробно описаны команды с параметрами. 


