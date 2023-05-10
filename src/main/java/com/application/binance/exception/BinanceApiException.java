package com.application.binance.exception;

/**
 * Исключение, которое может возникнуть при вызове методов Binance API.
 *
 * @author alexanderbibik
 */
public class BinanceApiException extends RuntimeException {

    /**
     * Объект ошибки, возвращаемый Binance API.
     */
    private BinanceApiError error;

    /**
     * Создает новое исключение BinanceApiException.
     *
     * @param error объект ошибки
     */
    public BinanceApiException(BinanceApiError error) {
        this.error = error;
    }

    /**
     * Создает новое исключение BinanceApiException.
     */
    public BinanceApiException() {
        super();
    }

    /**
     * Создает новое исключение BinanceApiException.
     *
     * @param message сообщение об ошибке
     */
    public BinanceApiException(String message) {
        super(message);
    }

    /**
     * Создает новое исключение BinanceApiException.
     *
     * @param cause причина исключения
     */
    public BinanceApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Создает новое исключение BinanceApiException.
     *
     * @param message сообщение об ошибке
     * @param cause   причина исключения
     */
    public BinanceApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Возвращает объект ошибки, полученный от Binance API.
     *
     * @return Объект ошибки BinanceApiError, или null, если объект ошибки не был возвращен (например, сервер вернул код 500).
     */
    public BinanceApiError getError() {
        return error;
    }

    /**
     * Возвращает сообщение об ошибке.
     *
     * @return Сообщение об ошибке или сообщение из объекта ошибки, если он не равен null.
     */
    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}