CREATE TABLE tickers
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE UNIQUE INDEX name_unique_idx ON tickers (name);

CREATE TABLE prices
(
    ticker_id INTEGER REFERENCES tickers (id),
    time      TIMESTAMP      NOT NULL,
    value     NUMERIC(10, 7) NOT NULL,
    PRIMARY KEY (ticker_id, time)
);

CREATE INDEX prices_ticker_id_idx ON prices (ticker_id);